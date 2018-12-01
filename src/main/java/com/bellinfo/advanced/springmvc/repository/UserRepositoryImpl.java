package com.bellinfo.advanced.springmvc.repository;

import com.bellinfo.advanced.springmvc.model.UserDetails;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }


    @Override
    public void addUserDetails(UserDetails userDetails) {
        getSession().save(userDetails);

    }

    @Override
    public void updateUserDetails(UserDetails userDetails) {

        UserDetails ud = getSession().get(UserDetails.class, userDetails.getId());

        ud.setUsername(userDetails.getUsername());
        ud.setPassword(userDetails.getPassword());
        getSession().saveOrUpdate(ud);

    }
    @Override
    public List<UserDetails> getUserDetails() {
        Criteria c = getSession().createCriteria(UserDetails.class);
        List<UserDetails> udlist = c.list();
        return udlist;
    }

    @Override
    public UserDetails getUserDetails(int id) {
        UserDetails ds = getSession().get(UserDetails.class,id);
        return ds;
    }

    @Override
    public UserDetails getUserDetails(String name) {
        List<UserDetails> list = getSession().createCriteria(UserDetails.class).add(Restrictions.eq("username", name)).list();
        if(list == null || list.isEmpty() || list.size() == 0){
            return null;
        }
        return list.get(0);
    }

    @Override
    public void deleteUserDetails(int id) {
        UserDetails us = getUserDetails(id);
        getSession().delete(us);

    }


}

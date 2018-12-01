package com.bellinfo.advanced.springmvc.service;

import com.bellinfo.advanced.springmvc.model.UserDetails;
import com.bellinfo.advanced.springmvc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public void addUserDetails(UserDetails userDetails) {
        userRepository.addUserDetails(userDetails);

    }

    @Override
    public void updateUserDetails(UserDetails userDetails) {
        userRepository.updateUserDetails(userDetails);

    }

    @Override
    public List<UserDetails> getUserDetails() {
        List<UserDetails> ulist = userRepository.getUserDetails();
        return ulist;
    }

    @Override
    public UserDetails getUserDetails(int id) {
        UserDetails uds = userRepository.getUserDetails(id);
        return uds;
    }

    @Override
    public UserDetails getUserDetails(String username) {
        UserDetails uds = userRepository.getUserDetails(username);
        return uds;
    }

    @Override
    public void deleteUserDetails(int id) {
        userRepository.deleteUserDetails(id);

    }
}

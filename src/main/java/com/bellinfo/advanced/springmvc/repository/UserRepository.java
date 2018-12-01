package com.bellinfo.advanced.springmvc.repository;

import com.bellinfo.advanced.springmvc.model.UserDetails;

import java.util.List;

public interface UserRepository {

    void addUserDetails(UserDetails userDetails);

    void updateUserDetails(UserDetails userDetails);

    List<UserDetails> getUserDetails();

    UserDetails getUserDetails(int id);

    UserDetails getUserDetails(String name);

    void deleteUserDetails(int id);

}

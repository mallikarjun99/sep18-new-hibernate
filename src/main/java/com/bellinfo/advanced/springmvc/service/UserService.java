package com.bellinfo.advanced.springmvc.service;

import com.bellinfo.advanced.springmvc.model.UserDetails;

import java.util.List;

public interface UserService {

    void addUserDetails(UserDetails userDetails);

    void updateUserDetails(UserDetails userDetails);

    List<UserDetails>getUserDetails();

    UserDetails getUserDetails(int id);

    UserDetails getUserDetails(String username);


    void deleteUserDetails(int id);


}

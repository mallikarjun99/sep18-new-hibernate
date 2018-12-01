package com.bellinfo.advanced.springmvc.controller;

import com.bellinfo.advanced.springmvc.model.UserDetails;
import com.bellinfo.advanced.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/userDetails")
public class UserController {


    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method= RequestMethod.GET)
    public String getIndex(Model model){
        UserDetails us  = new UserDetails();
        model.addAttribute("userDetails", us);
        return "login";

    }

    @RequestMapping(value = "/index", method= RequestMethod.GET)
    public String getIndexPage(Model model){
        UserDetails us = new UserDetails();
        model.addAttribute("userDetails", us);
        return "login";

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUserDetails(Model model){
        UserDetails us = new UserDetails();
        model.addAttribute("userDetails", us);
        return "login";

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUserDetails(@ModelAttribute UserDetails userDetails, Model model) {
        UserDetails details = userService.getUserDetails(userDetails.getUsername());
        if(details == null){
            userService.addUserDetails(userDetails);
        } else {
            model.addAttribute("error", "user already exists");
            return "login";
        }

        return "login";
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getUserDetails(Model model){
        List<UserDetails> list = userService.getUserDetails();
        model.addAttribute("list",list);
        return "list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editUserDetails(@PathVariable int id, Model model){
        UserDetails ud = userService.getUserDetails(id);
        model.addAttribute("userDetails",ud);
        return "edit";
    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.POST)
    public String editUserDetails(@ModelAttribute UserDetails userDetails,@PathVariable int id, Model model){
        userService.updateUserDetails(userDetails);
        List<UserDetails> list = userService.getUserDetails();
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET )
    public String deleteUserDetails(@PathVariable int id, Model model){
        userService.deleteUserDetails(id);
        List<UserDetails> list = userService.getUserDetails();
        model.addAttribute("list", list);
        return "list";
    }





}

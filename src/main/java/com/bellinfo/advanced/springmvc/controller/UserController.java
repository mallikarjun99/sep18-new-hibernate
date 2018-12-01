package com.bellinfo.advanced.springmvc.controller;

import com.bellinfo.advanced.springmvc.model.UserDetails;
import com.bellinfo.advanced.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    public String addUserDetails(@ModelAttribute UserDetails us, Model model) {
        UserDetails ud = userService.getUserDetails(us.getUsername());
        if(ud == null){
            model.addAttribute("message","Added successfully");
        } else{
            model.addAttribute("error", "user already exists");
        }

       // model.addAttribute("error", "user already exists");
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

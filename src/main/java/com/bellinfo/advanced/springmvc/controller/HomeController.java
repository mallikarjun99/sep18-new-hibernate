package com.bellinfo.advanced.springmvc.controller;

import com.bellinfo.advanced.springmvc.model.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class HomeController {
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
}

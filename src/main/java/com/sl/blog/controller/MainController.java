package com.sl.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    //首页
    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }
    @GetMapping("/index")
    public String index() {
        return "index";
    }


    @GetMapping("/login")
    public String login(){
        return "login";
    }

}

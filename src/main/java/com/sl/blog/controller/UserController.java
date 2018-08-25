package com.sl.blog.controller;


import com.sl.blog.domain.User;
import com.sl.blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public ModelAndView list(@RequestParam(value="async",required = false) boolean async,
                             @RequestParam(value="pageIndex",required = false, defaultValue = "0") int pageIndex,
                             @RequestParam(value="pageSize",required = false,defaultValue = "10") int pageSize,
                             @RequestParam(value="name",required=false,defaultValue = "") String name,
                             Model model){
        Pageable pageable = new PageRequest(pageIndex,pageSize);
        Page<User> page = userService.listUsersByName(name,pageable);

        List<User> list = page.getContent();
        model.addAttribute("page",page);
        model.addAttribute("userList",list);

        return new ModelAndView(async==true?"users/list :: #mainContainerReplace":"users/list","userModel",model);


    }
}

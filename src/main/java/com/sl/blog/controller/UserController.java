package com.sl.blog.controller;


import com.sl.blog.domain.Authority;
import com.sl.blog.domain.User;
import com.sl.blog.service.IUserService;
import com.sl.blog.util.ConstraintViolationExceptionHandler;
import com.sl.blog.vo.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 用户列表
     * @param async
     * @param pageIndex
     * @param pageSize
     * @param name
     * @param model
     * @return
     */
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


    /**
     * 新增user视图
     * @param model
     * @return
     */
    @GetMapping("/add")
    public ModelAndView createUser(Model model){
        model.addAttribute("user",new User(null,null,null,null));
        return new ModelAndView("users/add","userModel",model);
    }

    /**
     * 新增user逻辑处理
     * @param user
     * @param authorityId
     * @return
     */
    @PostMapping
    public ResponseEntity<Response> create(User user,Long authorityId){
        List<Authority> authorities = new ArrayList<>();
        //authorities.add(authorityService.getAuthorityById(authorityId));
        //user.setAuthorities(authorities);

        if(user.getId()==null){
            //加密密码
        }else{
            //编辑处理
        }

        try{
            userService.saveUser(user);
        }catch (ConstraintViolationException e){
            return ResponseEntity.ok().body(new Response(false, ConstraintViolationExceptionHandler.getMessage(e)));
        }
        return ResponseEntity.ok().body(new Response(true,"success",user));
    }


    @GetMapping(value="edit/{id}")
    public ModelAndView modifyUser(@PathVariable("id") Long id,Model model){
        User user = userService.getUserBuId(id);
        model.addAttribute("user",user);
        return new ModelAndView("users/edit","userModel",model);
    }


    /**
     * 删除用户
     * @param id
     * @param model
     * @return
     */
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Response> deleteUser(@PathVariable("id") Long id,Model model){
        try{
            userService.deleteUser(id);
        }catch(Exception e){
            return ResponseEntity.ok().body(new Response(false,e.getMessage()));
        }

        return ResponseEntity.ok().body(new Response(true,"处理成功"));
    }



}

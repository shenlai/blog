package com.sl.blog.service.impl;

import com.sl.blog.domain.User;
import com.sl.blog.repository.IUserRepository;
import com.sl.blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService,UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User saveUser(User user) {
       return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    @Override
    public User getUserBuId(Long id) {
        //区别 getOne findOne
        return  userRepository.getOne(id);
    }

    @Override
    public List<User> listUsers() {
        return  userRepository.findAll();
    }

    @Override
    public Page<User> listUsersByName(String name, Pageable pageable) {

        String nameCondition = "%"+name+"%";
        Page<User> users = userRepository.findByNameLike(nameCondition,pageable);
        return users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}

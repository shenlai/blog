package com.sl.blog.service;

import com.sl.blog.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IUserService {

    User saveUser(User user);

    void deleteUser(Long id);

    User getUserBuId(Long id);

    List<User> listUsers();

    Page<User> listUsersByName(String name, Pageable pageable);
}

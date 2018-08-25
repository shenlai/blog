package com.sl.blog.repository;

import com.sl.blog.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {


    Page<User> findByNameLike(String name, Pageable pageable);
}

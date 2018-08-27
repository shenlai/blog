package com.sl.blog.repository;

import com.sl.blog.domain.Blog;
import com.sl.blog.domain.Catalog;
import com.sl.blog.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog,Long> {


    Page<Blog> findByUserAndTitleLikeOrderByCreateTimeDesc(User user, String title, Pageable pageable);

    Page<Blog> findByUserAndTitleLike(User user,String title,Pageable pageable);


    //根据用户名分页查询用户列表
    Page<Blog> findByCatalog(Catalog catalog, Pageable pageable);

    //根据用户名分页查询用户列表
    //findByTitleLikeAndUserOrTagsLikeAndUserOrderByCreateTimeDesc
    Page<Blog> findByTitleLikeAndUserOrTagsLikeAndUserOrderByCreateTimeDesc(String title,User user,String tags,User user2,Pageable pageable);
}

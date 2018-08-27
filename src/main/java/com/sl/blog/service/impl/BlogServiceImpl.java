package com.sl.blog.service.impl;

import com.sl.blog.domain.Blog;
import com.sl.blog.domain.User;
import com.sl.blog.repository.IBlogRepository;
import com.sl.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Transactional
    @Override
    public Blog saveBlog(Blog blog) {

        return blogRepository.save(blog);
    }
    @Transactional
    @Override
    public void removeBlog(Long id) {
        blogRepository.delete(id);
    }

    @Override
    public Blog getBlogById(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public Page<Blog> listBlogsByTitleLike(User user, String title, Pageable pageable) {
        String titleCon = "%" + title + "%";
        Page<Blog> blogs = blogRepository.findByUserAndTitleLike(user, titleCon, pageable);
        return blogs;
    }

    @Override
    public Page<Blog> listBlogsByTitleLikeAndSort(User user, String title, Pageable pageable) {
        // 模糊查询
        title = "%" + title + "%";
        Page<Blog> blogs = blogRepository.findByUserAndTitleLikeOrderByCreateTimeDesc(user, title, pageable);
        return blogs;
    }

    @Transactional
    @Override
    public void readingIncrease(Long id) {
        Blog blog = blogRepository.findOne(id);
        blog.setReadSize(blog.getReadSize() + 1);
        blogRepository.save(blog);
    }
}

package com.sl.blog.service;

import com.sl.blog.domain.Blog;
import com.sl.blog.domain.Catalog;
import com.sl.blog.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {

    Blog saveBlog(Blog blog);

    void removeBlog(Long id);

    Blog getBlogById(Long id);

    Page<Blog> listBlogsByTitleLike(User user, String title, Pageable pageable);


    Page<Blog> listBlogsByTitleLikeAndSort(User suser, String title, Pageable pageable);

    /**
     * 阅读量递增
     * @param id
     */
    void readingIncrease(Long id);


    // 发表评论
    Blog createComment(Long blogId, String commentContent);


    // 删除评论
    void removeComment(Long blogId, Long commentId);

    //点赞
    Blog createVote(Long blogId);


    //取消点赞
    void removeVote(Long blogId, Long voteId);


     //根据分类进行查询
    Page<Blog> listBlogsByCatalog(Catalog catalog, Pageable pageable);

    //根据用户名进行分页模糊查询（最新）

    Page<Blog> listBlogsByTitleVote(User user, String title, Pageable pageable);

    //根据用户名进行分页模糊查询（最热）
    Page<Blog> listBlogsByTitleVoteAndSort(User suser, String title, Pageable pageable);
}

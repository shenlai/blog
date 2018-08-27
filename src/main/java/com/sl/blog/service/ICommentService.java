package com.sl.blog.service;

import com.sl.blog.domain.Comment;

public interface ICommentService {

    Comment getCommentById(Long id);

    void DeleteComment(Long id);
}

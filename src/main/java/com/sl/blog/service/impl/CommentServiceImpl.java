package com.sl.blog.service.impl;

import com.sl.blog.domain.Comment;
import com.sl.blog.repository.ICommentRepository;
import com.sl.blog.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements ICommentService {


    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.getOne(id);
    }

    @Override
    public void DeleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}

package com.sl.blog.repository;

import com.sl.blog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<Comment,Long> {

}

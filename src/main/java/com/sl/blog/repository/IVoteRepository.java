package com.sl.blog.repository;

import com.sl.blog.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVoteRepository extends JpaRepository<Vote, Long> {

}


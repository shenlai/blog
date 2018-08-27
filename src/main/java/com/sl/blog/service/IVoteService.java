package com.sl.blog.service;

import com.sl.blog.domain.Vote;

public interface IVoteService {

    Vote getVoteById(Long id);

    void removeVote(Long id);
}

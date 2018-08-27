package com.sl.blog.service.impl;

import com.sl.blog.domain.Vote;
import com.sl.blog.repository.IVoteRepository;
import com.sl.blog.service.IVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements IVoteService {

    @Autowired
    private IVoteRepository voteRepository;

    @Override
    public Vote getVoteById(Long id) {
        return voteRepository.getOne(id);
    }

    @Override
    public void removeVote(Long id) {
        voteRepository.delete(id);
    }
}

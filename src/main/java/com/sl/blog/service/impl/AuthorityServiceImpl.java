package com.sl.blog.service.impl;

import com.sl.blog.domain.Authority;
import com.sl.blog.repository.IAuthorityRepository;
import com.sl.blog.service.IAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements IAuthorityService {


    @Autowired
    private IAuthorityRepository authorityRepository;

    @Override
    public Authority getAuthorityById(Long id) {
        return authorityRepository.findOne(id);
    }
}

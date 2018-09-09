package com.sl.blog.service;

import com.sl.blog.domain.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEsBlogService {

    Page<EsBlog> getEsBlogByKeys(String keyword, Pageable pageable);
}

package com.sl.blog.repository;

import com.sl.blog.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorityRepository extends JpaRepository<Authority,Long> {
}

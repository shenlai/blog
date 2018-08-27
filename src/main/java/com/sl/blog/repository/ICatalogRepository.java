package com.sl.blog.repository;

import com.sl.blog.domain.Catalog;
import com.sl.blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ICatalogRepository extends JpaRepository<Catalog, Long> {

    List<Catalog> findByUser(User user);

    List<Catalog> findByUserAndName(User user,String name);
}
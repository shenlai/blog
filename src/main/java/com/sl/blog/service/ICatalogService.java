package com.sl.blog.service;

import com.sl.blog.domain.Catalog;
import com.sl.blog.domain.User;

import java.util.List;

public interface ICatalogService {

    Catalog saveCatalog(Catalog catalog);

    void removeCatalog(Long id);

    Catalog getCatalogById(Long id);

    List<Catalog> listCatalogs(User user);
}

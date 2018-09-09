package com.sl.blog.service.impl;

import com.sl.blog.domain.EsBlog;
import com.sl.blog.repository.IEsBlogRepository;
import com.sl.blog.service.IEsBlogService;
import joptsimple.internal.Strings;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

@Service
public class EsBlogServiceImpl implements IEsBlogService {


    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private IEsBlogRepository esBlogRepository;

    /**
     * 通过关键字搜索
     * @param keyword
     * @param pageable
     * @return
     */
    @Override
    public Page<EsBlog> getEsBlogByKeys(String keyword, Pageable pageable){
        Sort sort = new Sort(Sort.Direction.DESC,"read_size","comment_size","like_size");
        if (pageable.getSort() == null) {
            pageable = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), sort);
        }
        if(Strings.isNullOrEmpty(keyword)){
           return esBlogRepository.findAll(pageable);
        }
        //keyword 含有空格时抛异常
        //return esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContainingOrTagsContaining(keyword, keyword, keyword, keyword, pageable);

        //使用 Elasticsearch API QueryBuilder
        NativeSearchQueryBuilder aNativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        aNativeSearchQueryBuilder.withIndices("sl_blog").withTypes("blog");
        final BoolQueryBuilder aQuery = new BoolQueryBuilder();
        //builder下有的must、should、mustNot 相当于逻辑运算and、or、not
        aQuery.should(QueryBuilders.queryStringQuery(keyword).defaultField("title"));
        aQuery.should(QueryBuilders.queryStringQuery(keyword).defaultField("summary"));
        aQuery.should(QueryBuilders.queryStringQuery(keyword).defaultField("tags"));
        aQuery.should(QueryBuilders.queryStringQuery(keyword).defaultField("content"));

        NativeSearchQuery nativeSearchQuery = aNativeSearchQueryBuilder.withQuery(aQuery).build();
        Page<EsBlog> plist = elasticsearchTemplate.queryForPage(nativeSearchQuery,EsBlog.class);
        return  plist;

    }

}

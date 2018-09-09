package com.sl.blog;

import com.sl.blog.domain.EsBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@ComponentScan(basePackages={"com.sl.blog"})
@EnableElasticsearchRepositories(basePackages = {"com.sl.blog.repository"})
public class BlogApplication {


	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);

	}
}

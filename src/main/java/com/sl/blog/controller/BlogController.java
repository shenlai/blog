package com.sl.blog.controller;
import com.sl.blog.domain.EsBlog;
import com.sl.blog.service.IBlogService;
import com.sl.blog.service.IEsBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @Autowired
    private IEsBlogService esBlogService;

    @GetMapping
    public String listBlogs(@RequestParam(value="order",required=false,defaultValue="new") String order,
                            @RequestParam(value="keyword",required=false,defaultValue="" ) String keyword,
                            @RequestParam(value="async",required=false) boolean async,
                            @RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
                            @RequestParam(value="pageSize",required=false,defaultValue="5") int pageSize,
                            Model model) {
        Pageable pageable = new PageRequest(pageIndex,pageSize);
        Page<EsBlog> page = esBlogService.getEsBlogByKeys(keyword,pageable);
        List<EsBlog> list  = page.getContent();
        model.addAttribute("order", order);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("blogList", list);
        return (async==true?"/index :: #mainContainerRepleace":"/index");
    }

    /*
    public String blogList(
            @RequestParam(value="order",required = false,defaultValue = "new") String order,
            @RequestParam(value="keyword",required = false,defaultValue = "") String keyword,
            @RequestParam(value="async",required = false) boolean async,
            @RequestParam(value = "pageIndex",required = false,defaultValue = "0") int pageIndex,
            @RequestParam(value="pageSize",required = false,defaultValue = "10") int pageSize,
            Model model){
        Page<EsBlog> page=null;



        return (async==true?"/index :: #mainContainerReplace":"/index");
    }
    */


}

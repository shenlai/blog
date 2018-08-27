package com.sl.blog.controller;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @GetMapping
    public String listBlogs(@RequestParam(value="order",required=false,defaultValue="new") String order,
                            @RequestParam(value="tag",required=false) Long tag) {
        System.out.print("order:" +order + ";tag:" +tag );
        return "redirect:/index?order="+order+"&tag="+tag;
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

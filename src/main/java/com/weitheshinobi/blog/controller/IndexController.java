package com.weitheshinobi.blog.controller;

import com.weitheshinobi.blog.constant.BlogConstant;
import com.weitheshinobi.blog.service.BlogService;
import com.weitheshinobi.blog.service.TagService;
import com.weitheshinobi.blog.service.TypeService;
import com.weitheshinobi.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static com.weitheshinobi.blog.constant.BlogConstant.*;

@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;


    @GetMapping("/")
    public String index(@PageableDefault(size = 8,sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                        Model model){
        model.addAttribute(PAGE,blogService.listBlog(pageable));
        model.addAttribute(TYPE,typeService.listType());
        model.addAttribute(TAG,tagService.listTag());
        model.addAttribute(RECOMMEND_BLOG,blogService.listRecommendBlogTop(8));
        return "index";
    }

    @GetMapping("/blog/{id}")
    public String blog(){
        return "blog";
    }

}

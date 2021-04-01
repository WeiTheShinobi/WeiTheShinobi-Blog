package com.weitheshinobi.blog.controller;

import com.weitheshinobi.blog.pojo.Comment;
import com.weitheshinobi.blog.service.BlogService;
import com.weitheshinobi.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @Value("${comment.avatar}")
    private String avatar;

    @RequestMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model){
        model.addAttribute("comments",commentService.listCommentByBlogId(blogId));
        return "blog :: commentList";
    }

    @RequestMapping("/comments")
    public String post(Comment comment){
        Long blogId = comment.getBlog().getId();
        blogService.saveBlog(blogService.getBlogById(blogId));
        comment.setAvatar(avatar);
        commentService.saveComment(comment);
        return "redirect:/comments/" + blogId;
    }


}

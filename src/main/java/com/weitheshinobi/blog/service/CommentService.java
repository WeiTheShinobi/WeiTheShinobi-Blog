package com.weitheshinobi.blog.service;

import com.weitheshinobi.blog.pojo.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}

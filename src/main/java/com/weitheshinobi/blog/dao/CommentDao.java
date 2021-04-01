package com.weitheshinobi.blog.dao;

import com.weitheshinobi.blog.pojo.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment,Long> {

    List<Comment> findCommentsByBlogId(Long blogId, Sort sort);

    Comment findCommentsById(Long blogId);

}

package com.weitheshinobi.blog.service;

import com.weitheshinobi.blog.dao.CommentDao;
import com.weitheshinobi.blog.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {
        Sort sort = Sort.by(Sort.DEFAULT_DIRECTION,"createTime");
        return commentDao.findCommentsByBlogId(blogId,sort);
    }

    @Transactional
    @Override
    public Comment saveComment(Comment comment) {
        Long parentCommendId = comment.getComment().getId();
        if (parentCommendId != -1){
            comment.setComment(commentDao.findCommentsById(parentCommendId));
        } else {
            comment.setComment(null);
        }
        comment.setCreateTime(new Date());
        return commentDao.save(comment);
    }
}

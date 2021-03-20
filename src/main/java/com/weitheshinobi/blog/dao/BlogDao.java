package com.weitheshinobi.blog.dao;

import com.weitheshinobi.blog.pojo.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BlogDao extends JpaRepository<Blog,Long> , JpaSpecificationExecutor<Blog> {
    Blog findBlogById(Long id);
}

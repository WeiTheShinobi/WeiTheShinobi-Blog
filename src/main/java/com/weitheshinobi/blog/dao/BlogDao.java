package com.weitheshinobi.blog.dao;

import com.weitheshinobi.blog.pojo.Blog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogDao extends JpaRepository<Blog,Long> , JpaSpecificationExecutor<Blog> {
    Blog findBlogById(Long id);

    @Query("select b from Blog b where b.recommend = true")
    List<Blog> findTop(Pageable pageable);
}

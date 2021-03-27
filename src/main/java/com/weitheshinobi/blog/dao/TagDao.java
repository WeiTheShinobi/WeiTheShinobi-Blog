package com.weitheshinobi.blog.dao;

import com.weitheshinobi.blog.pojo.Tag;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TagDao extends JpaRepository<Tag,Long> {
    Tag findTagById(Long id);

    Tag findTagByName(String name);

}

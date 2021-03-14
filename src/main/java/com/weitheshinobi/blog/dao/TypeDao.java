package com.weitheshinobi.blog.dao;

import com.weitheshinobi.blog.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeDao extends JpaRepository<Type,Long> {
    Type findTypeById(Long id);
}

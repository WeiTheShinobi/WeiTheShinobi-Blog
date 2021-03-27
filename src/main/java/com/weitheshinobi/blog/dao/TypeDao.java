package com.weitheshinobi.blog.dao;

import com.weitheshinobi.blog.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeDao extends JpaRepository<Type,Long> {
    Type findTypeById(Long id);

    Type findTypeByName(String name);

}

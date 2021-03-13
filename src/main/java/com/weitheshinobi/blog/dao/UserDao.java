package com.weitheshinobi.blog.dao;

import com.weitheshinobi.blog.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {

    User findByUsernameAndPassword(String username,String password);
}

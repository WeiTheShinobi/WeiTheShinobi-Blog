package com.weitheshinobi.blog.service;


import com.weitheshinobi.blog.pojo.User;

public interface UserService {
    User checkUser(String username, String password);
}

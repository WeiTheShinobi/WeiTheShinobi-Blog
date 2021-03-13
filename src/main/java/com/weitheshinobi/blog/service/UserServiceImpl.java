package com.weitheshinobi.blog.service;

import com.weitheshinobi.blog.dao.UserDao;
import com.weitheshinobi.blog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

//    調用DAO層
    @Autowired
    UserDao userDao;

//    登入確認
    @Override
    public User checkUser(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }
}

package com.weitheshinobi.blog.service;

import com.weitheshinobi.blog.dao.UserRepository;
import com.weitheshinobi.blog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

//    調用DAO層
    @Autowired
    UserRepository userRepository;

//    登入確認
    @Override
    public User checkUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}

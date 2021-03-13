package com.weitheshinobi.blog.service;

import com.weitheshinobi.blog.dao.UserDao;
import com.weitheshinobi.blog.pojo.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserDao userDao;

    @Test
    void checkUser() {
//        設定mock
        Mockito.when(userDao.findByUsernameAndPassword("abc","123")).thenReturn(new User());

        User user = userService.checkUser("abc", "123");
        assertNotNull(user);

    }
}
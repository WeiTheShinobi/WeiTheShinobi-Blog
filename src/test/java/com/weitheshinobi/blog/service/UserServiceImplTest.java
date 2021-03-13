package com.weitheshinobi.blog.service;

import com.weitheshinobi.blog.dao.UserDao;
import com.weitheshinobi.blog.pojo.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @InjectMocks
    private UserService userService;

    @MockBean
    private UserDao userDao;

    @Test
    void checkUser() {
        User nullUser = userService.checkUser("", "");
        assertNull(nullUser);

        //        設定mock
        Mockito.when(userDao.findByUsernameAndPassword(Mockito.anyString(),Mockito.anyString())).thenReturn(new User());
        User user = userService.checkUser("abc", "123");
        assertNotNull(user);

    }
}
package com.weitheshinobi.blog.service;

import com.weitheshinobi.blog.dao.UserDao;
import com.weitheshinobi.blog.pojo.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UserServiceImplTest {

    @InjectMocks
    UserService userService = new UserServiceImpl();

    @Mock
    UserDao userDao;

    @Test
    void checkUser_nameAndPassword_getUser() {
        Mockito.when(userDao.findByUsernameAndPassword(Mockito.anyString(),Mockito.anyString())).thenReturn(new User());
        User user = userService.checkUser("abc", "123");
        assertNotNull(user);
    }
}
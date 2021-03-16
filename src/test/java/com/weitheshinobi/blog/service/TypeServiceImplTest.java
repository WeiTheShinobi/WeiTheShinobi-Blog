package com.weitheshinobi.blog.service;

import com.weitheshinobi.blog.dao.TypeDao;
import com.weitheshinobi.blog.pojo.Type;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class TypeServiceImplTest {

    private static Long ID = 1L;

    @InjectMocks
    TypeService typeService = new TypeServiceImpl();

    @Mock
    TypeDao typeDao;

    @Test
    void saveType_type() {
        Type type = new Type();
        typeService.saveType(type);
        verify(typeDao).save(type);
    }

    @Test
    void getTypeById_long_notNull() {
        when(typeDao.findTypeById(anyLong())).thenReturn(new Type());
        Type type = typeService.getTypeById(ID);
        assertNotNull(type);
    }

    @Test
    void getTypeByName_string_notNull() {
        when(typeDao.findTypeByName(anyString())).thenReturn(new Type());
        Type type = typeService.getTypeByName("name");
        assertNotNull(type);
    }

    @Test
    void listType() {

    }

    @Test
    void updateType_idAndType() {

    }

    @Test
    void deleteType_Id() {
        typeService.deleteType(ID);
        verify(typeDao).deleteById(ID);
    }
}
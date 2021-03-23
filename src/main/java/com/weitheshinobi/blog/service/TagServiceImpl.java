package com.weitheshinobi.blog.service;

import com.weitheshinobi.blog.dao.TagDao;
import com.weitheshinobi.blog.pojo.Tag;
import com.weitheshinobi.blog.pojo.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        return tagDao.save(tag);
    }

    @Override
    public Tag getTagById(Long id) {
        return tagDao.findTagById(id);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagDao.findTagByName(name);
    }

    @Override
    public Page<Tag> listTag(Pageable pageable) {
        return tagDao.findAll(pageable);
    }

    @Override
    public List<Tag> listTag() {
        return tagDao.findAll();
    }

    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag t = tagDao.findTagById(id);
        if(t == null){
            return null;
        }
        BeanUtils.copyProperties(tag,t);
        return tagDao.save(t);
    }

    @Override
    public void deleteTag(Long id) {
        tagDao.deleteById(id);
    }
}

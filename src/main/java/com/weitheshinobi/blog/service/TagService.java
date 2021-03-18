package com.weitheshinobi.blog.service;

import com.weitheshinobi.blog.pojo.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TagService {
    Tag saveTag(Tag tag);

    Tag getTagById(Long id);

    Tag getTagByName(String name);

    Page<Tag> listTag(Pageable pageable);

    Tag updateTag(Long id,Tag tag);

    void deleteTag(Long id);
}

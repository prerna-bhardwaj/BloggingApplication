package com.example.blog.services;

import java.util.List;

import com.example.blog.exchanges.GetTagObject;
import com.example.blog.models.Tag;

public interface TagService {
    
    public String addTag(GetTagObject tag);
    public List<Tag> fetchAllTags();
    public Tag fetchTagById(Long id);
}

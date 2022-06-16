package com.example.blog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.exchanges.GetTagObject;
import com.example.blog.models.Tag;
import com.example.blog.repositories.TagRepository;

@Service
public class TagServiceImpl implements TagService{

    @Autowired
    private TagRepository tagRepository;

    @Override
    public String addTag(GetTagObject tagObject) {
        Tag tag = new Tag(tagObject.getTagName());
        tagRepository.save(tag);
        return "Tag saved successfully";
    }

    @Override
    public List<Tag> fetchAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tag fetchTagById(Long id) {
        return tagRepository.findById(id).get();
    }
    
}

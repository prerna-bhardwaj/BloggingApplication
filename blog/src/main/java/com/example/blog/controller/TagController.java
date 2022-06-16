package com.example.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.exchanges.GetTagObject;
import com.example.blog.models.Tag;
import com.example.blog.services.TagServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/tags")
public class TagController {
    
    public static final String ADD_TAG = "/add";
    public static final String FETCH_ALL_TAGS = "/fetchAll";
    
    @Autowired
    private TagServiceImpl tagService;

    @PostMapping(ADD_TAG)
    public String addTagApi(@RequestBody GetTagObject tagName) {
        return tagService.addTag(tagName);
    }

    @GetMapping(FETCH_ALL_TAGS)
    public List<Tag> fetchAllTagsApi() {
        return tagService.fetchAllTags();
    }
}

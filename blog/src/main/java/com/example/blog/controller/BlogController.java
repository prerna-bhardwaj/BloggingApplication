package com.example.blog.controller;

import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.blog.exchanges.GetBlogObject;
import com.example.blog.exchanges.UserResponse;
import com.example.blog.models.Blog;
import com.example.blog.models.User;
import com.example.blog.services.BlogServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin
@RequestMapping("/blogs/")
public class BlogController {
    
    public static final String CREATE_BLOG = "/create";
    public static final String UPDATE_BLOG = "/update";
    public static final String DELETE_BLOG = "/delete/{blogId}";
    public static final String FETCH_ALL_BLOGS = "/fetch";
    public static final String FETCH_BLOG_BY_ID = "/fetch/{blogId}";
    public static final String SEARCH_BY_TAG = "/search/{tagId}";
    public static final String GET_AUTHOR_FOR_BLOG = "/author/{blogId}";

    @Autowired
    public BlogServiceImpl blogServiceImpl;

    @PostMapping(CREATE_BLOG)
    public String createBlogApi(@RequestParam("object") String blogJson, 
                                    @RequestParam("file") MultipartFile file) throws IOException {
        // Add blog to database - object + file
        ObjectMapper objectMapper = new ObjectMapper();
        GetBlogObject blog = null;
        blog = objectMapper.readValue(blogJson, GetBlogObject.class);
    
        blogServiceImpl.createBlog(blog, file);
        return "Blog created successfully";
    }

    @PutMapping(UPDATE_BLOG)
    public String updateBlogApi(@RequestBody Blog blog) {
        // Update blog in database
        blogServiceImpl.updateBlog(blog);
        return "Blog has been updated successfully";
    }

    @DeleteMapping(DELETE_BLOG)
    public String deleteBlogApi(@PathVariable Long blogId) {
        return blogServiceImpl.deleteBlog(blogId);
    }

    @GetMapping(FETCH_ALL_BLOGS)
    public List<Blog> fetchAllBlogsApi() {
        System.out.println("fetch all blogs");
        return blogServiceImpl.fetchAllBlogs();
    }

    @GetMapping(FETCH_BLOG_BY_ID) 
    public ResponseEntity<Blog> fetchBlogById(@PathVariable Long blogId) throws JsonProcessingException {
        Blog blog = blogServiceImpl.fetchBlogById(blogId);
        return ResponseEntity.ok().body(blog);
    }
    
    @GetMapping(SEARCH_BY_TAG)
    public Set<Blog> searchBlogsByTag(@PathVariable Long tagId) {
        // Fetch blogs by tagId
        Set<Blog> blogs = blogServiceImpl.searchBlogsByTag(tagId);
        return blogs;
    }

    @GetMapping(GET_AUTHOR_FOR_BLOG)
    public UserResponse getAuthorForBlog(@PathVariable Long blogId) {
        UserResponse user = blogServiceImpl.getAuthor(blogId);
        return user;
    }

}

package com.example.blog.services;

import java.io.IOException;
import java.util.*;

import org.springframework.web.multipart.MultipartFile;

import com.example.blog.exchanges.GetBlogObject;
import com.example.blog.exchanges.UserResponse;
import com.example.blog.models.Blog;
import com.example.blog.models.User;

public interface BlogService {
    
    public String createBlog(GetBlogObject blog, MultipartFile file) throws IOException;
    public String updateBlog(Blog blog);
    public String deleteBlog(Long blogId);
    public List<Blog> fetchAllBlogs();
    public Blog fetchBlogById(Long blogId);
    public Set<Blog> searchBlogsByTag(Long tagId);
    public UserResponse getAuthor(Long blogId);

}

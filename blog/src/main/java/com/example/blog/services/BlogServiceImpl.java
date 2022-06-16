package com.example.blog.services;

import java.io.IOException;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.blog.exchanges.GetBlogObject;
import com.example.blog.exchanges.UserResponse;
import com.example.blog.models.Blog;
import com.example.blog.models.Tag;
import com.example.blog.models.User;
import com.example.blog.repositories.BlogRepository;
import com.example.blog.repositories.UserRepository;
import com.example.blog.util.ImageUtility;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TagServiceImpl tagService;
    @PersistenceContext
    private EntityManager em;

    public String createBlog(GetBlogObject blogDto, MultipartFile file) throws IOException {
        // Save a blog
        System.out.println(blogDto);
        byte[] compressedImage = ImageUtility.compressImage(file.getBytes());
        Blog blog = new Blog(blogDto.getTitle(),  blogDto.getDescription(), 
                                blogDto.getBody(), compressedImage);
        List<Long> tags = blogDto.getTags();
        for(Long tagId : tags) {
            Tag tag = tagService.fetchTagById(tagId);
            blog.addTag(tag);
        }
        Optional<User> user = userRepository.findById(blogDto.getUserId());
        User userObject = user.get();
        userObject.addBlog(blog);
        System.out.println(blog.getTags());
        blogRepository.save(blog);
        return "done";
    }

    public String updateBlog(Blog blog) {
        blogRepository.updateBlogInfoById(blog.getTitle(), blog.getBody(), blog.getId());
        return "updated successfully";
    }

    public String deleteBlog(Long blogId) {
        try {
            blogRepository.deleteById(blogId);
        } catch(EmptyResultDataAccessException e) {
            return "Blog with given id does not exist";
        }
        return "Blog deleted successfully";
    }

    public List<Blog> fetchAllBlogs() {
        List<Blog> blogs = blogRepository.findAll();
        return blogs;
    }

    public Blog fetchBlogById(Long blogId) {
        Blog blog =  blogRepository.findById(blogId).get();
        System.out.println(blog);
        blog.setImage(ImageUtility.decompressImage(blog.getImage()));
        return blog;
    }

    public Set<Blog> searchBlogsByTag(Long tagId) {
        Tag tag = tagService.fetchTagById(tagId);
        return tag.getBlogs();
    }

    public UserResponse getAuthor(Long blogId) {
        String queryString = "SELECT user_id FROM blogs WHERE id=" + blogId;
        System.out.println(queryString);
        Query q = em.createNativeQuery(queryString);
        Long userId = Long.valueOf(q.getResultList().get(0).toString());
        User user = userRepository.findById(userId).get();
        UserResponse userResponse = new UserResponse(user.getId(), user.getName());
        return userResponse;
    }
    
}

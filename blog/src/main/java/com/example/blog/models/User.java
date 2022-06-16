package com.example.blog.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
@SequenceGenerator(name="user_sequence_gen", sequenceName = "user_sequence", 
                        initialValue = 100, allocationSize = 1)
public class User {

    private static final int MIN_USERNAME_LENGTH = 5;
    private static final int MIN_PASSWORD_LENGTH = 7;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence_gen")
    private Long id;    

    @NotEmpty(message = "Please enter name")
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    
    @Length(min = MIN_USERNAME_LENGTH, message = "Username must be atleast " + MIN_USERNAME_LENGTH
                    + " characters long")
    @NotEmpty(message = "Please enter username")
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    // Just in case password is returned
    // @JsonIgnore
    @Length(min = MIN_PASSWORD_LENGTH, message = "Password must be atleast " + MIN_PASSWORD_LENGTH
                    + " characters long")
    @NotEmpty(message = "Please enter password")
    @Column(name = "password", nullable = false, unique = true)
    private String password;

    @OneToMany(targetEntity = Blog.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<Blog> blogs;

    public User() {}

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.blogs = null;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Blog> getBlogs() {
        return this.blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public String toString() {
        return this.id + " " + this.name + " " + this.username + " " + this.password;
    }

    public void addBlog(Blog blog) {
        if(blogs == null)
            blogs = new ArrayList<Blog>();
        blogs.add(blog);
    }

}

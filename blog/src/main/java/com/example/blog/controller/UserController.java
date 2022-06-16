package com.example.blog.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.exchanges.DataObject;
import com.example.blog.exchanges.GetLoginObject;
import com.example.blog.exchanges.GetRegisterObject;
import com.example.blog.models.Blog;
import com.example.blog.models.User;
import com.example.blog.services.UserServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("users/")
public class UserController {
    
    public static final String REGISTER_API = "/register/{name}/{username}/{password}";
    public static final String LOGIN_API = "/login/{username}/{password}";
    public static final String GET_USER_BY_USERNAME = "/{username}";

    @Autowired
    private UserServiceImpl userService;

    @PostMapping(REGISTER_API)
    public Long userRegister(@PathVariable String name, @PathVariable String username,
            @PathVariable String password) {
        // Call service method and create user if not existing previously
        GetRegisterObject registerObject = new GetRegisterObject(name, username, password);
        Long ans = userService.registerUser(registerObject);
        return ans;
    }

    @GetMapping(LOGIN_API)
    public User userLogin(@PathVariable String username, @PathVariable String password) {
        // Call service to log the user in 
        GetLoginObject loginObject = new GetLoginObject(username, password);
        User user = userService.loginUser(loginObject);
        System.out.println(user);
        return user;
    }

    @GetMapping(GET_USER_BY_USERNAME)
    public User getUserByUsername(@PathVariable String username) {
        // Call service to get blogs for a user
        return userService.getUser(username);
    }
}

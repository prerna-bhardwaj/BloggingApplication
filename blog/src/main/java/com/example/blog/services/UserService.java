package com.example.blog.services;

import java.util.List;

import com.example.blog.exchanges.GetLoginObject;
import com.example.blog.exchanges.GetRegisterObject;
import com.example.blog.models.User;

public interface UserService {
    
    public Long registerUser(GetRegisterObject registerObject);
    public User loginUser(GetLoginObject loginObject);
    public User getUser(String username);

}

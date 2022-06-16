package com.example.blog.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blog.exchanges.GetLoginObject;
import com.example.blog.exchanges.GetRegisterObject;
import com.example.blog.models.Blog;
import com.example.blog.models.User;
import com.example.blog.repositories.UserRepository;
import javax.persistence.Query;;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    @PersistenceContext
    private EntityManager em;

    public Long registerUser(GetRegisterObject registerObject) {
        String name = registerObject.getName();
        String username = registerObject.getUsername();
        String password = registerObject.getPassword();
        System.out.println(name + " " + username + " " + password);
        User user = new User(name, username, password);
        userRepository.save(user);
        return user.getId();
    }

    public User loginUser(GetLoginObject loginObject) {
        String username = loginObject.getUsername();
        String password = loginObject.getPassword();
        List<User> users = userRepository.findByUsernameAndPassword(username, password);
        System.out.println(users);
        if(users.size() != 1)
            return null;
        return users.get(0);
    }

    public User getUser(String username) {
        User user = userRepository.findByUsername(username).get(0);
        return user;
    }

}

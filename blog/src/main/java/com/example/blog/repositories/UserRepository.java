package com.example.blog.repositories;

import java.util.List;

import javax.persistence.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blog.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
    List<User> findByUsername(String username);
    List<User> findByUsernameAndPassword(String username, String password);

}

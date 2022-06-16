package com.example.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.blog.models.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    
}

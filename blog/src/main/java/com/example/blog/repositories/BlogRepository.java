package com.example.blog.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.transaction.annotation.Transactional;

import com.example.blog.models.Blog;

public interface BlogRepository extends JpaRepository<Blog, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Blog b set b.title = ?1, b.body = ?2 where b.id = ?3")
    void updateBlogInfoById(String title, String body, Long id);

}

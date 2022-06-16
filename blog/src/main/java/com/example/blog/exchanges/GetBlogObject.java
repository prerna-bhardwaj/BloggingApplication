package com.example.blog.exchanges;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NotNull
@NoArgsConstructor
@JsonIgnoreProperties("id")
public class GetBlogObject {
    
    private String title;
    private String description;
    private String body;
    private Long userId;
    private List<Long> tags;

    public GetBlogObject() {}

    public GetBlogObject(String title, String description, String body, 
            Long userId, List<Long> tags) {
        this.body = body;
        this.title = title;
        this.userId = userId;
        this.description = description;
        this.tags = tags;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long id) {
        this.userId = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getTags() {
        return this.tags;
    }

    public void setTags(List<Long> tags) {
        this.tags = tags;
    }

    public String toString() {
        return this.title + " " + this.description + " " 
                + this.body + " " + this.userId + " " + this.tags;
    }
}


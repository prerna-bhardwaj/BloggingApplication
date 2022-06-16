package com.example.blog.models;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tags")
@SequenceGenerator(name = "tag_sequence_gen", sequenceName = "tag_sequence",
                    initialValue = 100, allocationSize = 1)
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_sequence_gen")
    private Long id;

    @NotEmpty(message = "Please enter a Tag Name")
    @Column(name = "tagName", nullable = false)
    private String tagName;

    // @JsonBackReference
    @ManyToMany(mappedBy = "tags")
    @JsonIgnoreProperties("tags")
    private Set<Blog> blogs = new HashSet<>(); 

    public Tag() {}

    public Tag(String tagName) {
        this.tagName = tagName;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return this.tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Set<Blog> getBlogs() {
        return this.blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }

    public String toString() {
        return this.id + " " + this.tagName;
    }

}

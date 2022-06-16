package com.example.blog.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blogs")
@EnableAutoConfiguration
@SequenceGenerator(name = "blog_sequence_gen", sequenceName = "blog_sequence", 
                        initialValue = 100, allocationSize = 1)
public class Blog {

    private static final int MIN_TITLE_LENGTH = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blog_sequence_gen")
    private Long id;


    @Length(min = MIN_TITLE_LENGTH, message = "Title must be atleast " + MIN_TITLE_LENGTH
                        + " characters long")
    @NotEmpty(message = "Please enter the title")
    @Column(name = "title", nullable = false)
    private String title;

    @NotEmpty(message = "Please enter description")
    @Column(name = "description", nullable = false)
    private String description;

    @NotEmpty(message = "Please enter some content")
    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "posted_at")
    private Date postedAt = new Date();

    @Column(name = "image", unique = false, nullable = false, length = 100000)
	private byte[] image;

    // @JsonManagedReference
    @ManyToMany
    @JoinTable(name = "post_tags", 
                joinColumns = {@JoinColumn(name = "post_id")},
                inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    @JsonIgnoreProperties("blogs")
    private Set<Tag> tags = new HashSet<>();

    public Blog() {}

    public Blog(String title, String description, String body, byte[] image) {
        this.title = title;
        this.description = description;
        this.body = body;
        this.image = image;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPostedAt() {
        return this.postedAt;
    }

    public void setPostedAt(Date date) {
        this.postedAt = date;
    }

    public byte[] getImage() {
        return this.image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Set<Tag> getTags() {
        return this.tags;
    }

    public void setTags(HashSet<Tag> tags) {
        this.tags = tags;
    }

    public void addTag(Tag tag) {
        if(tags == null)
            tags = new HashSet<>();
        tags.add(tag);
    }

}
package com.maven.bourbon_backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Document
public class Review {

    @Id
    private String id;
    @Field
    private String name;
    @Field
    private Double rating;
    @Field
    private String content;

    public Review(){}

    public Review(@JsonProperty("id") String id,
                  @JsonProperty("name") String name,
                  @JsonProperty("rating") Double rating,
                  @JsonProperty("content") String content){
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

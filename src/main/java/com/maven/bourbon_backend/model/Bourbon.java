package com.maven.bourbon_backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Bourbon {

    @Id
    private String name;
    @Field
    private String distil;
    @Field
    private Double proof;
    @Field
    private Double rating;


    public Bourbon(@JsonProperty("name") String name,
                   @JsonProperty("distil") String distil,
                   @JsonProperty("proof") Double proof) {
        this.name = name;
        this.distil = distil;
        this.proof = proof;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistil() {
        return distil;
    }

    public void setDistil(String distil) {
        this.distil = distil;
    }

    public Double getProof() {
        return proof;
    }

    public void setProof(Double proof) {
        this.proof = proof;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}

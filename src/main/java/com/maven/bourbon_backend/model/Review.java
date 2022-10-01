package com.maven.bourbon_backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document
public class Review {

    @Id
    private String id;
    @Field
    private String name;
    @Field
    private Double rating;
    @Field
    private Double taste;
    @Field
    private Double nose;
    @Field
    private Double mouthfeel;
    @Field
    private Double value;
    @Field
    private Double availability;
    @Field
    private String content;
    @Field("Profile_id")
    private String Profile_id;
    @Field("Bourbon_id")
    private String Bourbon_id;


    public Review(@JsonProperty("id") String id,
                  @JsonProperty("name") String name,
                  @JsonProperty("rating") Double rating,
                  @JsonProperty("taste") Double taste,
                  @JsonProperty("nose") Double nose,
                  @JsonProperty("mouthfeel") Double mouthfeel,
                  @JsonProperty("value") Double value,
                  @JsonProperty("availability") Double availability,
                  @JsonProperty("content") String content,
                  @JsonProperty("Profile_id") String Profile_id,
                  @JsonProperty("Bourbon_id") String Bourbon_id){
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.taste = taste;
        this.nose = nose;
        this.mouthfeel = mouthfeel;
        this.value = value;
        this.availability = availability;
        this.content = content;
        this.Profile_id = Profile_id;
        this.Bourbon_id = Bourbon_id;
    }

    public String getProfile_id() {
        return Profile_id;
    }

    public void setProfile_id(String profile_id) {
        Profile_id = profile_id;
    }

    public String getBourbon_id() {
        return Bourbon_id;
    }

    public void setBourbon_id(String bourbon_id) {
        Bourbon_id = bourbon_id;
    }

    public Double getTaste() {
        return taste;
    }

    public void setTaste(Double taste) {
        this.taste = taste;
    }

    public Double getNose() {
        return nose;
    }

    public void setNose(Double nose) {
        this.nose = nose;
    }

    public Double getMouthfeel() {
        return mouthfeel;
    }

    public void setMouthfeel(Double mouthfeel) {
        this.mouthfeel = mouthfeel;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getAvailability() {
        return availability;
    }

    public void setAvailability(Double availability) {
        this.availability = availability;
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

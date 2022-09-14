package com.maven.bourbon_backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document
public class Profile {

    @Id
    private String id;
    @Field
    private String name;
    @Field
    private List<String> bourbon_ids;


    public Profile(){}

    public Profile (@JsonProperty("id") String id,
                    @JsonProperty("name") String name,
                    @JsonProperty("bourbon_ids") List<String> bourbon_ids){
        this.id = id;
        this.name = name;
        this.bourbon_ids = bourbon_ids;
    }

    public List<String> getBourbon_ids() {
        return bourbon_ids;
    }

    public void setBourbon_ids(List<String> bourbon_ids) {
        this.bourbon_ids = bourbon_ids;
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
}

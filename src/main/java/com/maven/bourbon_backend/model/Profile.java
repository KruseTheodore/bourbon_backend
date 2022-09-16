package com.maven.bourbon_backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;
import java.util.List;

@Document
public class Profile {

    @Id
    private String id;
    @Field
    private String name;
    @Field
    private String password;
    @Field("bourbon_ids")
    private List<String> bourbon_ids;
    @Field
    private Collection<Role> roles;


    public Profile(){}

    public Profile (@JsonProperty("id") String id,
                    @JsonProperty("name") String name,
                    @JsonProperty("password") String password,
                    @JsonProperty("bourbon_ids") List<String> bourbon_ids,
                    @JsonProperty("roles") Collection<Role> roles){
        this.id = id;
        this.name = name;
        this.password = password;
        this.bourbon_ids = bourbon_ids;
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
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

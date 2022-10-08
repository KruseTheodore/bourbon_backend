package com.maven.bourbon_backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;
import java.util.HashSet;
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
    @Field("followed_names")
    private List<String> followed_names;


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
        if(roles == null){
            Collection<Role> newRoles = new HashSet<Role>();
            newRoles.add(new Role("1", "User"));
            this.roles = newRoles;
        }
        else{
            this.roles = roles;
        }
    }

    public List<String> getFollowed_names() {
        return followed_names;
    }

    public void setFollowed_names(List<String> followed_names) {
        this.followed_names = followed_names;
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

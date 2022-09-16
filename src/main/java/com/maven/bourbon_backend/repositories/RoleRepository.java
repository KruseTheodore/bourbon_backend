package com.maven.bourbon_backend.repositories;


import com.maven.bourbon_backend.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("MongoRole")
public interface RoleRepository extends MongoRepository<Role, String> {

}

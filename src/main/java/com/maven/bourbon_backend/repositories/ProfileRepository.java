package com.maven.bourbon_backend.repositories;

import com.maven.bourbon_backend.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("MongoProfile")
public interface ProfileRepository extends MongoRepository<Profile, String> {

}

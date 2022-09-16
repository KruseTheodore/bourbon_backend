package com.maven.bourbon_backend.repositories;

import com.maven.bourbon_backend.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("MongoProfile")
public interface ProfileRepository extends MongoRepository<Profile, String> {

    @Query
    Profile findByName(String name);

    @Query(value = "{'bourbon_ids':'?0'}")
    List<Profile> findByBourbonIDs(String bourbon_id);

}

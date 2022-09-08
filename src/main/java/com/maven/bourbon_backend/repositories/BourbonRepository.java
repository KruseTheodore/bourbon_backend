package com.maven.bourbon_backend.repositories;

import com.maven.bourbon_backend.model.Bourbon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository("MongoBourbon")
public interface BourbonRepository extends MongoRepository<Bourbon, String> {


}

package com.maven.bourbon_backend.repositories;

import com.maven.bourbon_backend.model.RefreshToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("MongoRefresh")
public interface RefreshRepository extends MongoRepository<RefreshToken, String> {
}

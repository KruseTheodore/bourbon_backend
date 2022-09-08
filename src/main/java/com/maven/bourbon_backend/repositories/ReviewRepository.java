package com.maven.bourbon_backend.repositories;

import com.maven.bourbon_backend.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("MongoReview")
public interface ReviewRepository extends MongoRepository<Review, String> {


}

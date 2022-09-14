package com.maven.bourbon_backend.repositories;

import com.maven.bourbon_backend.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("MongoReview")
public interface ReviewRepository extends MongoRepository<Review, String> {

    @Query(value = "{'Profile_id':'?0'}")
    List<Review> findAllReviewsByProfile(String profile_id);

    @Query(value = "{'Bourbon_id':'?0'}")
    List<Review> findAllReviewsByBourbon(String bourbon_id);

}

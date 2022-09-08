package com.maven.bourbon_backend.service;

import com.maven.bourbon_backend.repositories.ReviewRepository;
import com.maven.bourbon_backend.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(@Qualifier("MongoReview") ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void addReview(Review review){
        reviewRepository.save(review);
    }

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(String id){
        return reviewRepository.findById(id);
    }

    public void deleteReviewById(String id){
        reviewRepository.deleteById(id);
    }

    public void updateReviewById(String id, Review review){
        reviewRepository.deleteById(id);
        reviewRepository.save(review);
    }


}

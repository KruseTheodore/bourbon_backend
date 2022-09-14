package com.maven.bourbon_backend.service;

import com.maven.bourbon_backend.model.Bourbon;
import com.maven.bourbon_backend.model.Profile;
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
    private final ProfileService profileService;
    private final BourbonService bourbonService;

    @Autowired
    public ReviewService(@Qualifier("MongoReview") ReviewRepository reviewRepository, ProfileService profileService, BourbonService bourbonService) {
        this.reviewRepository = reviewRepository;
        this.profileService = profileService;
        this.bourbonService = bourbonService;
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

    public Optional<Profile> getProfileForReview(Review review){
        return profileService.getProfileById(review.getProfile_id());
    }

    public Optional<Bourbon> getBourbonBeingReviewed(Review review){
        return bourbonService.getBourbonByName(review.getBourbon_id());
    }

    public List<Review> getAllReviewsByProfile(String profile_id){
        return reviewRepository.findAllReviewsByProfile(profile_id);
    }

    public List<Review> getAllReviewsByBourbon(String bourbon_name){
        return reviewRepository.findAllReviewsByBourbon(bourbon_name);
    }


}

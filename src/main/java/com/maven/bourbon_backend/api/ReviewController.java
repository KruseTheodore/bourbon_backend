package com.maven.bourbon_backend.api;

import com.maven.bourbon_backend.model.Review;
import com.maven.bourbon_backend.service.ReviewService;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("BourbonCommunityReviews/review")
@RestController
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public void addReview(@RequestBody Review review){
        reviewService.addReview(review);
    }

    @GetMapping
    public List<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }

    @GetMapping(path = "{id}")
    public Optional<Review> getReviewById(@PathVariable("id") String id){
        return reviewService.getReviewById(id);
    }

    @DeleteMapping(path = "{id}")
    public void deleteReviewById(@PathVariable("id") String id){
        reviewService.deleteReviewById(id);
    }

    @PutMapping(path = "{id}")
    public void updateReviewById(@PathVariable("id") String id, @RequestBody Review review){
        reviewService.updateReviewById(id, review);
    }
}

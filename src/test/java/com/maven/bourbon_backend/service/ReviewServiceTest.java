package com.maven.bourbon_backend.service;

import com.maven.bourbon_backend.model.Bourbon;
import com.maven.bourbon_backend.model.Review;
import com.maven.bourbon_backend.repositories.ReviewRepository;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class ReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;
    @Mock
    private ProfileService profileService;
    @Mock
    private BourbonService bourbonService;

    private ReviewService underTest;

    @BeforeEach
    void setUp(){
              underTest = new ReviewService(reviewRepository, profileService, bourbonService);
    }


    @Test
    void canAddReview() {
        //given
        Review review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        //when
        underTest.addReview(review);
        //then
        ArgumentCaptor<Review> reviewArgumentCaptor = ArgumentCaptor.forClass(Review.class);
        verify(reviewRepository).save(reviewArgumentCaptor.capture());
        Review capturedReview = reviewArgumentCaptor.getValue();
        assertThat(capturedReview).isEqualTo(review);
    }

    @Test
    void canGetAllReviews() {
        //when
        underTest.getAllReviews();
        //then
        verify(reviewRepository).findAll();
    }

    @Test
    void canGetReviewById() {
        //given
        String identification = "Id";
        //when
        underTest.getReviewById(identification);
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(reviewRepository).findById(stringArgumentCaptor.capture());
        String capturedString = stringArgumentCaptor.getValue();
        assertThat(capturedString).isEqualTo(identification);
    }

    @Test
    void canDeleteReviewById() {
        //given
        String identification = "Id";
        //when
        underTest.deleteReviewById(identification);
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(reviewRepository).deleteById(stringArgumentCaptor.capture());
        String capturedString = stringArgumentCaptor.getValue();
        assertThat(capturedString).isEqualTo(identification);
    }

    @Test
    void canUpdateReviewById() {
        //given
        String identification = "Id";
        Review review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        //when
        underTest.updateReviewById(identification, review);
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Review> reviewArgumentCaptor = ArgumentCaptor.forClass(Review.class);
        verify(reviewRepository).deleteById(stringArgumentCaptor.capture());
        verify(reviewRepository).save(reviewArgumentCaptor.capture());
        String capturedString = stringArgumentCaptor.getValue();
        Review capturedReview = reviewArgumentCaptor.getValue();
        SoftAssertions bundle = new SoftAssertions();
        bundle.assertThat(capturedString).isEqualTo(identification);
        bundle.assertThat(capturedReview).isEqualTo(review);
        bundle.assertAll();
    }

    @Test
    void canGetProfileForReview() {
        //given
        Review review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        //when
        underTest.getProfileForReview(review);
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(profileService).getProfileById(stringArgumentCaptor.capture());
        String capturedString = stringArgumentCaptor.getValue();
        assertThat(capturedString).isEqualTo(review.getProfile_id());
    }

    @Test
    void canGetBourbonBeingReviewed() {
        //given
        Review review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        //when
        underTest.getBourbonBeingReviewed(review);
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(bourbonService).getBourbonByName(stringArgumentCaptor.capture());
        String capturedString = stringArgumentCaptor.getValue();
        assertThat(capturedString).isEqualTo(review.getProfile_id());
    }

    @Test
    void canGetAllReviewsByProfile() {
        //given
        String profileId = "Id";
        //when
        underTest.getAllReviewsByProfile(profileId);
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(reviewRepository).findAllReviewsByProfile(stringArgumentCaptor.capture());
        String capturedString = stringArgumentCaptor.getValue();
        assertThat(capturedString).isEqualTo(profileId);
    }

    @Test
    void canGetAllReviewsByBourbon() {
        //given
        String bourbonName = "Id";
        //when
        underTest.getAllReviewsByBourbon(bourbonName);
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(reviewRepository).findAllReviewsByBourbon(stringArgumentCaptor.capture());
        String capturedString = stringArgumentCaptor.getValue();
        assertThat(capturedString).isEqualTo(bourbonName);
    }
}
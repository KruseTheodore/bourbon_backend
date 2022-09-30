package com.maven.bourbon_backend.api;

import com.maven.bourbon_backend.model.Review;
import com.maven.bourbon_backend.service.ReviewService;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class ReviewControllerTest {

    @Mock
    private ReviewService reviewService;
    private ReviewController underTest;

    @BeforeEach
    void setUp(){
        underTest = new ReviewController(reviewService);
    }

    @Test
    void canAddReview() {
        //given
        Review review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        //when
        underTest.addReview(review);
        //then
        ArgumentCaptor<Review> reviewArgumentCaptor = ArgumentCaptor.forClass(Review.class);
        verify(reviewService).addReview(reviewArgumentCaptor.capture());
        Review capturedReview = reviewArgumentCaptor.getValue();
        assertThat(capturedReview).isEqualTo(review);
    }

    @Test
    void canGetAllReviews() {
        //when
        underTest.getAllReviews();
        //then
        verify(reviewService).getAllReviews();
    }

    @Test
    void canGetReviewById() {
        //given
        String identification = "Id";
        //when
        underTest.getReviewById(identification);
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(reviewService).getReviewById(stringArgumentCaptor.capture());
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
        verify(reviewService).deleteReviewById(stringArgumentCaptor.capture());
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
        verify(reviewService).updateReviewById(stringArgumentCaptor.capture(), reviewArgumentCaptor.capture());
        String capturedString = stringArgumentCaptor.getValue();
        Review capturedReview = reviewArgumentCaptor.getValue();
        SoftAssertions bundle = new SoftAssertions();
        bundle.assertThat(capturedString).isEqualTo(identification);
        bundle.assertThat(capturedReview).isEqualTo(review);
        bundle.assertAll();
    }

    @Test
    @Disabled
    void canGetProfileByReview() {
    }

    @Test
    @Disabled
    void canGetBourbonBeingReviewed() {
    }

    @Test
    void canGetAllReviewsByProfile() {
        //given
        String profileId = "Id";
        //when
        underTest.getAllReviewsByProfile(profileId);
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(reviewService).getAllReviewsByProfile(stringArgumentCaptor.capture());
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
        verify(reviewService).getAllReviewsByBourbon(stringArgumentCaptor.capture());
        String capturedString = stringArgumentCaptor.getValue();
        assertThat(capturedString).isEqualTo(bourbonName);
    }
}
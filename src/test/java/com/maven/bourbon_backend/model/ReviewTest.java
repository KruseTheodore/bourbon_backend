package com.maven.bourbon_backend.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class ReviewTest {

    private Review review;

    @BeforeEach
    void setUp(){
        review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
    }

    @Test
    void canGetProfile_id() {
        //given review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        //when
        String PID = review.getProfile_id();
        //then
        assertThat(PID).isEqualTo("testID");

    }

    @Test
    void canSetProfile_id() {
        //given review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        //when
        review.setProfile_id("newID");
        //then
        assertThat(review.getProfile_id()).isEqualTo("newID");
    }

    @Test
    void canGetBourbon_id() {
        //given review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        //when
        String BID = review.getBourbon_id();
        //then
        assertThat(BID).isEqualTo("testID");
    }

    @Test
    void canSetBourbon_id() {
        //given review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        //when
        review.setBourbon_id("newID");
        //then
        assertThat(review.getBourbon_id()).isEqualTo("newID");
    }

    @Test
    void canGetTaste() {
        //given review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        //when
        Double taste = review.getTaste();
        //then
        assertThat(taste).isEqualTo(3.0);
    }

    @Test
    void canSetTaste() {
        //given review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        //when
        review.setTaste(4.0);
        //then
        assertThat(review.getTaste()).isEqualTo(4.0);
    }

    @Test
    void canGetNose() {
        //given review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        //when
        Double nose = review.getNose();
        //then
        assertThat(nose).isEqualTo(3.0);
    }

    @Test
    void canSetNose() {
        //given review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        //when
        review.setNose(4.0);
        //then
        assertThat(review.getNose()).isEqualTo(4.0);
    }

    @Test
    void canGetMouthfeel() {
        //given review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        //when
        Double mouthfeel = review.getMouthfeel();
        //then
        assertThat(mouthfeel).isEqualTo(3.0);
    }

    @Test
    void canSetMouthfeel() {
        //given review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        //when
        review.setMouthfeel(4.0);
        //then
        assertThat(review.getMouthfeel()).isEqualTo(4.0);
    }

    @Test
    void canGetValue() {
        //given review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        //when
        Double value = review.getValue();
        //then
        assertThat(value).isEqualTo(3.0);
    }

    @Test
    void canSetValue() {
        //given review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        //when
        review.setValue(4.0);
        //then
        assertThat(review.getValue()).isEqualTo(4.0);
    }

    @Test
    void canGetAvailability() {
        //given review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        //when
        Double availability = review.getAvailability();
        //then
        assertThat(availability).isEqualTo(3.0);
    }

    @Test
    void canSetAvailability() {
        //given review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        //when
        review.setAvailability(4.0);
        //then
        assertThat(review.getAvailability()).isEqualTo(4.0);
    }

    @Test
    void canGetId() {
        //given review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        //when
        String id = review.getId();
        //then
        assertThat(id).isEqualTo("1");
    }

    @Test
    void canSetId() {
        //given review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        //when
        review.setId("2");
        //then
        assertThat(review.getId()).isEqualTo("2");
    }

    @Test
    void canGetName() {
        //given review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        //when
        String name = review.getName();
        //then
        assertThat(name).isEqualTo("testReview");
    }

    @Test
    void canSetName() {
        //given review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        //when
        review.setName("newReview");
        //then
        assertThat(review.getName()).isEqualTo("newReview");
    }

    @Test
    void canGetRating() {
        //given review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        Double rating = review.getRating();
        //then
        assertThat(rating).isEqualTo(3.0);
    }

    @Test
    void canSetRating() {
        //given review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        //when
        review.setRating(4.0);
        //then
        assertThat(review.getRating()).isEqualTo(4.0);
    }

    @Test
    void canGetContent() {
        //given review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        //when
        String content = review.getContent();
        //then
        assertThat(content).isEqualTo("review");
    }

    @Test
    void canSetContent() {
        //given review = new Review("1", "testReview", 3.0, 3.0, 3.0, 3.0, 3.0, 3.0, "review", "testID", "testID");
        //when
        review.setContent("newReview");
        //then
        assertThat(review.getContent()).isEqualTo("newReview");
    }
}
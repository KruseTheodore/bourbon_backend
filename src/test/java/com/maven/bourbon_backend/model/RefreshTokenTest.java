package com.maven.bourbon_backend.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class RefreshTokenTest {

    private RefreshToken refreshToken;

    @BeforeEach
    void setUp(){
        refreshToken = new RefreshToken("testToken");
    }

    @Test
    void canGetToken() {
        //given refreshToken = new RefreshToken("testToken");
        //when
        String token = refreshToken.getToken();
        //then
        assertThat(token).isEqualTo("testToken");
    }

    @Test
    void canSetToken() {
        //given refreshToken = new RefreshToken("testToken");
        //when
        refreshToken.setToken("newToken");
        //then
        assertThat(refreshToken.getToken()).isEqualTo("newToken");
    }
}
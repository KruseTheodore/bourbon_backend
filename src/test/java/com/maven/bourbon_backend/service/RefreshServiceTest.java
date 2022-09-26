package com.maven.bourbon_backend.service;

import com.maven.bourbon_backend.model.RefreshToken;
import com.maven.bourbon_backend.model.Role;
import com.maven.bourbon_backend.repositories.RefreshRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class RefreshServiceTest {

    @Mock
    private RefreshRepository refreshRepository;

    private RefreshService underTest;

    @BeforeEach
    void setUp(){
        underTest = new RefreshService(refreshRepository);
    }

    @Test
    void canSaveToken() {
        //given
        RefreshToken refreshToken = new RefreshToken("test");
        //when
        underTest.saveToken(refreshToken);
        //then
        ArgumentCaptor<RefreshToken> tokenArgumentCaptor = ArgumentCaptor.forClass(RefreshToken.class);
        verify(refreshRepository).save(tokenArgumentCaptor.capture());
        RefreshToken capturedToken = tokenArgumentCaptor.getValue();
        assertThat(capturedToken).isEqualTo(refreshToken);
    }

    @Test
    void canDeleteToken() {
        //given
        RefreshToken refreshToken = new RefreshToken("test");
        //when
        underTest.deleteToken(refreshToken);
        //then
        ArgumentCaptor<RefreshToken> tokenArgumentCaptor = ArgumentCaptor.forClass(RefreshToken.class);
        verify(refreshRepository).delete(tokenArgumentCaptor.capture());
        RefreshToken capturedToken = tokenArgumentCaptor.getValue();
        assertThat(capturedToken).isEqualTo(refreshToken);
    }

    @Test
    void canCheckToken() {
        //given
        RefreshToken refreshToken = new RefreshToken("test");
        //when
        underTest.checkToken(refreshToken);
        //then
        ArgumentCaptor<String> tokenArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(refreshRepository).existsById(tokenArgumentCaptor.capture());
        String capturedTokenID = tokenArgumentCaptor.getValue();
        assertThat(capturedTokenID).isEqualTo(refreshToken.getToken());
    }
}
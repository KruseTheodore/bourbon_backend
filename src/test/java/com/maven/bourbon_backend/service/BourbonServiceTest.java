package com.maven.bourbon_backend.service;

import com.maven.bourbon_backend.model.Bourbon;
import com.maven.bourbon_backend.repositories.BourbonRepository;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BourbonServiceTest {

    @Mock
    private BourbonRepository bourbonRepository;
    private BourbonService underTest;

    @BeforeEach
    void setUp(){
        underTest = new BourbonService(bourbonRepository);
    }

    @Test
    void canAddBourbon() {
        //given
        Bourbon bourbon = new Bourbon("testBourbon", "testDistil", 100.1);
        //when
        underTest.addBourbon(bourbon);
        //then
        ArgumentCaptor<Bourbon> bourbonArgumentCaptor = ArgumentCaptor.forClass(Bourbon.class);
        verify(bourbonRepository).save(bourbonArgumentCaptor.capture());
        Bourbon capturedBourbon = bourbonArgumentCaptor.getValue();
        assertThat(capturedBourbon).isEqualTo(bourbon);
    }

    @Test
    void canGetAllBourbons() {
        //when
        underTest.getAllBourbons();
        //then
        verify(bourbonRepository).findAll();
    }

    @Test
    void canGetBourbonByName() {
        //given
        String name = "testBourbon";
        //when
        underTest.getBourbonByName(name);
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(bourbonRepository).findById(stringArgumentCaptor.capture());
        String capturedName = stringArgumentCaptor.getValue();
        assertThat(capturedName).isEqualTo(name);
    }

    @Test
    void canDeleteBourbonByName() {
        //given
        String name = "testBourbon";
        //when
        underTest.deleteBourbonByName(name);
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(bourbonRepository).deleteById(stringArgumentCaptor.capture());
        String capturedName = stringArgumentCaptor.getValue();
        assertThat(capturedName).isEqualTo(name);
    }

    @Test
    void canUpdateBourbonById() {
        //given
        String name = "testBourbon";
        Bourbon bourbon = new Bourbon("testBourbon", "testDistil", 100.1);
        //when
        underTest.updateBourbonById(name, bourbon);
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Bourbon> bourbonArgumentCaptor = ArgumentCaptor.forClass(Bourbon.class);
        verify(bourbonRepository).deleteById(stringArgumentCaptor.capture());
        verify(bourbonRepository).save(bourbonArgumentCaptor.capture());
        String capturedName = stringArgumentCaptor.getValue();
        Bourbon capturedBourbon = bourbonArgumentCaptor.getValue();
        SoftAssertions bundle = new SoftAssertions();
        bundle.assertThat(capturedName).isEqualTo(name);
        bundle.assertThat(capturedBourbon).isEqualTo(bourbon);
        bundle.assertAll();
    }
}
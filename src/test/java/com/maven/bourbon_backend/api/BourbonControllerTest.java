package com.maven.bourbon_backend.api;

import com.maven.bourbon_backend.model.Bourbon;
import com.maven.bourbon_backend.service.BourbonService;
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
class BourbonControllerTest {

    @Mock
    private BourbonService bourbonService;
    private BourbonController underTest;

    @BeforeEach
    void setUp(){
        underTest = new BourbonController(bourbonService);
    }

    @Test
    void canAddBourbon() {
        //given
        Bourbon bourbon = new Bourbon("testBourbon", "testDistil", 100.1);
        //when
        underTest.addBourbon(bourbon);
        //then
        ArgumentCaptor<Bourbon> bourbonArgumentCaptor = ArgumentCaptor.forClass(Bourbon.class);
        verify(bourbonService).addBourbon(bourbonArgumentCaptor.capture());
        Bourbon capturedBourbon = bourbonArgumentCaptor.getValue();
        assertThat(capturedBourbon).isEqualTo(bourbon);
    }

    @Test
    void canGetAllBourbons() {
        //when
        underTest.getAllBourbons();
        //then
        verify(bourbonService).getAllBourbons();
    }

    @Test
    void canGetBourbonByName() {
        //given
        String name = "testBourbon";
        //when
        underTest.getBourbonByName(name);
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(bourbonService).getBourbonByName(stringArgumentCaptor.capture());
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
        verify(bourbonService).deleteBourbonByName(stringArgumentCaptor.capture());
        String capturedName = stringArgumentCaptor.getValue();
        assertThat(capturedName).isEqualTo(name);
    }

    @Test
    void canUpdateBourbonByName() {
        //given
        String name = "testBourbon";
        Bourbon bourbon = new Bourbon("testBourbon", "testDistil", 100.1);
        //when
        underTest.updateBourbonByName(name, bourbon);
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Bourbon> bourbonArgumentCaptor = ArgumentCaptor.forClass(Bourbon.class);
        verify(bourbonService).updateBourbonById(stringArgumentCaptor.capture(), bourbonArgumentCaptor.capture());
        String capturedName = stringArgumentCaptor.getValue();
        Bourbon capturedBourbon = bourbonArgumentCaptor.getValue();
        SoftAssertions bundle = new SoftAssertions();
        bundle.assertThat(capturedName).isEqualTo(name);
        bundle.assertThat(capturedBourbon).isEqualTo(bourbon);
        bundle.assertAll();
    }
}
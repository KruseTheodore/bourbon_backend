package com.maven.bourbon_backend.model;

import com.maven.bourbon_backend.service.BourbonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class BourbonTest {

    private Bourbon bourbon;

    @BeforeEach
    void setUp(){
        bourbon = new Bourbon("testName", "testDistil", 100.0);
    }

    @Test
    void canGetName() {
        //given bourbon = new Bourbon("testName", "testDistil", 100.0);
        //when
        String name = bourbon.getName();
        //then
        assertThat(name).isEqualTo("testName");
    }

    @Test
    void canSetName() {
        //given bourbon = new Bourbon("testName", "testDistil", 100.0);
        //when
        bourbon.setName("newName");
        //then
        assertThat(bourbon.getName()).isEqualTo("newName");
    }

    @Test
    void canGetDistil() {
        //given bourbon = new Bourbon("testName", "testDistil", 100.0);
        //when
        String distil = bourbon.getDistil();
        //then
        assertThat(distil).isEqualTo("testDistil");
    }

    @Test
    void canSetDistil() {
        //given bourbon = new Bourbon("testName", "testDistil", 100.0);
        //when
        bourbon.setDistil("newDistil");
        //then
        assertThat(bourbon.getDistil()).isEqualTo("newDistil");
    }

    @Test
    void canGetProof() {
        //given bourbon = new Bourbon("testName", "testDistil", 100.0);
        //when
        Double proof = bourbon.getProof();
        //then
        assertThat(proof).isEqualTo(100.0);
    }

    @Test
    void canSetProof() {
        //given bourbon = new Bourbon("testName", "testDistil", 100.0);
        //when
        bourbon.setProof(101.0);
        //then
        assertThat(bourbon.getProof()).isEqualTo(101.0);
    }
}
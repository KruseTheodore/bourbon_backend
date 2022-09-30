package com.maven.bourbon_backend.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class RoleTest {

    private Role role;

    @BeforeEach
    void setUp(){
        role = new Role("1", "test");
    }

    @Test
    void canGetId() {
        //given role = new Role("1", "test");
        //when
        String id = role.getId();
        //then
        assertThat(id).isEqualTo("1");
    }

    @Test
    void canSetId() {
        //given role = new Role("1", "test");
        //when
        role.setId("2");
        //then
        assertThat(role.getId()).isEqualTo("2");
    }

    @Test
    void canGetName() {
        //given role = new Role("1", "test");
        //when
        String name = role.getName();
        //then
        assertThat(name).isEqualTo("test");
    }

    @Test
    void canSetName() {
        //given role = new Role("1", "test");
        //when
        role.setName("newTest");
        //then
        assertThat(role.getName()).isEqualTo("newTest");
    }
}
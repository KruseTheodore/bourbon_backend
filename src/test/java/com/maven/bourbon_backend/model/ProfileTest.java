package com.maven.bourbon_backend.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class ProfileTest {

    private Profile profile;

    @BeforeEach
    void setUp(){
        String testName = "testName";
        List<String> testBourbons = new ArrayList<>();
        testBourbons.add("1920");
        Role role = new Role("1", "user");
        Collection<Role> testRoles = new ArrayList<>();
        testRoles.add(role);
        profile = new Profile("1", testName, "testPassword", testBourbons , testRoles);
    }

    @Test
    void canGetPassword() {
        //given profile = new Profile("1", testName, "testPassword", testBourbons , testRoles);
        //when
        String pass = profile.getPassword();
        //then
        assertThat(pass).isEqualTo("testPassword");
    }

    @Test
    void canSetPassword() {
        //given profile = new Profile("1", testName, "testPassword", testBourbons , testRoles);
        //when
        profile.setPassword("newPass");
        //then
        assertThat(profile.getPassword()).isEqualTo("newPass");
    }

    @Test
    void canGetRoles() {
        //given profile = new Profile("1", testName, "testPassword", testBourbons , testRoles);
        String testName = "testName";
        List<String> testBourbons = new ArrayList<>();
        testBourbons.add("1920");
        Role role = new Role("1", "user");
        Collection<Role> testRoles = new ArrayList<>();
        testRoles.add(role);
        profile = new Profile("1", testName, "testPassword", testBourbons , testRoles);
        //when
        Collection<Role> getRoles = profile.getRoles();
        //then
        assertThat(getRoles).isEqualTo(testRoles);
    }

    @Test
    void canSetRoles() {
        //given profile = new Profile("1", testName, "testPassword", testBourbons , testRoles);
        String testName = "testName";
        List<String> testBourbons = new ArrayList<>();
        testBourbons.add("1920");
        Role role = new Role("1", "user");
        Collection<Role> testRoles = new ArrayList<>();
        testRoles.add(role);
        profile = new Profile("1", testName, "testPassword", testBourbons , testRoles);
        //when
        Role newRole = new Role("2", "user2");
        Collection<Role> newRoles = new ArrayList<>();
        newRoles.add(role);
        profile.setRoles(newRoles);
        //then
        assertThat(profile.getRoles()).isEqualTo(newRoles);
    }

    @Test
    void canGetBourbon_ids() {
        //given profile = new Profile("1", testName, "testPassword", testBourbons , testRoles);
        String testName = "testName";
        List<String> testBourbons = new ArrayList<>();
        testBourbons.add("1920");
        Role role = new Role("1", "user");
        Collection<Role> testRoles = new ArrayList<>();
        testRoles.add(role);
        profile = new Profile("1", testName, "testPassword", testBourbons , testRoles);
        //when
        List<String> getBourbons = profile.getBourbon_ids();
        //then
        assertThat(getBourbons).isEqualTo(testBourbons);
    }

    @Test
    void canSetBourbon_ids() {
        //given profile = new Profile("1", testName, "testPassword", testBourbons , testRoles);
        String testName = "testName";
        List<String> testBourbons = new ArrayList<>();
        testBourbons.add("1920");
        Role role = new Role("1", "user");
        Collection<Role> testRoles = new ArrayList<>();
        testRoles.add(role);
        profile = new Profile("1", testName, "testPassword", testBourbons , testRoles);
        //when
        List<String> newBourbons = new ArrayList<>();
        testBourbons.add("Blantons");
        profile.setBourbon_ids(newBourbons);
        //then
        assertThat(profile.getBourbon_ids()).isEqualTo(newBourbons);
    }

    @Test
    void canGetId() {
        //given profile = new Profile("1", testName, "testPassword", testBourbons , testRoles);
        //when
        String id = profile.getId();
        //then
        assertThat(id).isEqualTo("1");
    }

    @Test
    void canSetId() {
        //given profile = new Profile("1", testName, "testPassword", testBourbons , testRoles);
        //when
        profile.setId("2");
        //then
        assertThat(profile.getId()).isEqualTo("2");
    }

    @Test
    void canGetName() {
        //given profile = new Profile("1", testName, "testPassword", testBourbons , testRoles);
        //when
        String name = profile.getName();
        //then
        assertThat(name).isEqualTo("testName");
    }

    @Test
    void canSetName() {
        //given profile = new Profile("1", testName, "testPassword", testBourbons , testRoles);
        //when
        profile.setName("newName");
        //then
        assertThat(profile.getName()).isEqualTo("newName");
    }
}
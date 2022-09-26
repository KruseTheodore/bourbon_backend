package com.maven.bourbon_backend.service;

import com.maven.bourbon_backend.model.Profile;
import com.maven.bourbon_backend.model.Review;
import com.maven.bourbon_backend.model.Role;
import com.maven.bourbon_backend.repositories.ProfileRepository;
import com.maven.bourbon_backend.repositories.RoleRepository;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class ProfileServiceTest {

    @Mock
    private ProfileRepository profileRepository;
    @Mock
    private  RoleRepository roleRepository;
    @Mock
    private  BourbonService bourbonService;
    @Mock
    private PasswordEncoder passwordEncoder;
    private ProfileService underTest;


    @BeforeEach
    void setUp(){
        underTest = new ProfileService(profileRepository, roleRepository, bourbonService, passwordEncoder);
    }

    @Test
    @Disabled
    void canLoadUserByUsername() {
        //given
        String testName = "testName";
        List<String> testBourbons = new ArrayList<>();
        testBourbons.add("1920");
        Role role = new Role("1", "user");
        Collection<Role> testRoles = new ArrayList<>();
        testRoles.add(role);
        Profile profile = new Profile("1", testName, "testPassword", testBourbons , testRoles);
        underTest.addProfile(profile);
        //when
        underTest.loadUserByUsername(testName);
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(profileRepository).findByName(stringArgumentCaptor.capture());
        String capturedString = stringArgumentCaptor.getValue();
        assertThat(capturedString).isEqualTo(testName);
    }

    @Test
    void canAddRole() {
        //given
        Role role = new Role("1", "user");
        //when
        underTest.addRole(role);
        //then
        ArgumentCaptor<Role> roleArgumentCaptor = ArgumentCaptor.forClass(Role.class);
        verify(roleRepository).save(roleArgumentCaptor.capture());
        Role capturedRole = roleArgumentCaptor.getValue();
        assertThat(capturedRole).isEqualTo(role);
    }

    @Test
    void canAddProfile() {
        //given
        String testName = "testName";
        List<String> testBourbons = new ArrayList<>();
        testBourbons.add("1920");
        Role role = new Role("1", "user");
        Collection<Role> testRoles = new ArrayList<>();
        testRoles.add(role);
        Profile profile = new Profile("1", testName, "testPassword", testBourbons , testRoles);
        //when
        underTest.addProfile(profile);
        //then
        ArgumentCaptor<Profile> profileArgumentCaptor = ArgumentCaptor.forClass(Profile.class);
        verify(profileRepository).save(profileArgumentCaptor.capture());
        Profile capturedProfile = profileArgumentCaptor.getValue();
        assertThat(capturedProfile).isEqualTo(profile);
    }

    @Test
    void canGetAllProfiles() {
        //when
        underTest.getAllProfiles();
        //then
        verify(profileRepository).findAll();
    }

    @Test
    void canGetProfileById() {
        //given
        String identification = "Id";
        //when
        underTest.getProfileById(identification);
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(profileRepository).findById(stringArgumentCaptor.capture());
        String capturedString = stringArgumentCaptor.getValue();
        assertThat(capturedString).isEqualTo(identification);
    }

    @Test
    void canDeleteProfileById() {
        //given
        String identification = "Id";
        //when
        underTest.deleteProfileById(identification);
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(profileRepository).deleteById(stringArgumentCaptor.capture());
        String capturedString = stringArgumentCaptor.getValue();
        assertThat(capturedString).isEqualTo(identification);
    }

    @Test
    void canUpdateProfileById() {
        //given
        String identification = "Id";
        String testName = "testName";
        List<String> testBourbons = new ArrayList<>();
        testBourbons.add("1920");
        Role role = new Role("1", "user");
        Collection<Role> testRoles = new ArrayList<>();
        testRoles.add(role);
        Profile profile = new Profile(identification, testName, "testPassword", testBourbons , testRoles);
        //when
        underTest.updateProfileById(identification, profile);
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Profile> profileArgumentCaptor = ArgumentCaptor.forClass(Profile.class);
        verify(profileRepository).deleteById(stringArgumentCaptor.capture());
        verify(profileRepository).save(profileArgumentCaptor.capture());
        String capturedString = stringArgumentCaptor.getValue();
        Profile capturedProfile = profileArgumentCaptor.getValue();
        SoftAssertions bundle = new SoftAssertions();
        bundle.assertThat(capturedString).isEqualTo(identification);
        bundle.assertThat(capturedProfile).isEqualTo(profile);
        bundle.assertAll();

    }

    @Test
    @Disabled
    void canGetBourbonsOnProfile() {
        //given
        String testName = "testName";
        List<String> testBourbons = new ArrayList<>();
        testBourbons.add("1920");
        Role role = new Role("1", "user");
        Collection<Role> testRoles = new ArrayList<>();
        testRoles.add(role);
        Profile profile = new Profile("1", testName, "testPassword", testBourbons , testRoles);
        //when
        underTest.getBourbonsOnProfile(profile);
        //then
        ArgumentCaptor<String> profileArgumentCaptor = ArgumentCaptor.forClass(String.class);
        List<String> capturedStrings = new ArrayList<>();
        Iterator<String> it = profile.getBourbon_ids().iterator();
        while(it.hasNext()) {
            verify(bourbonService).getBourbonByName(profileArgumentCaptor.capture());
            capturedStrings.add(profileArgumentCaptor.getValue());
        }
        assertThat(capturedStrings).isEqualTo(testBourbons);
    }

    @Test
    void canGetAllProfilesForABourbon() {
        //given
        String identification = "Id";
        //when
        underTest.getAllProfilesForABourbon(identification);
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(profileRepository).findByBourbonIDs(stringArgumentCaptor.capture());
        String capturedString = stringArgumentCaptor.getValue();
        assertThat(capturedString).isEqualTo(identification);
    }

    @Test
    void canGetProfileByName() {
        //given
        String testName = "testName";
        //when
        underTest.getProfileByName(testName);
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(profileRepository).findByName(stringArgumentCaptor.capture());
        String capturedString = stringArgumentCaptor.getValue();
        assertThat(capturedString).isEqualTo(testName);
    }
}
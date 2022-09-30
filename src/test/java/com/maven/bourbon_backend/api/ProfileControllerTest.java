package com.maven.bourbon_backend.api;

import com.maven.bourbon_backend.model.Profile;
import com.maven.bourbon_backend.model.Role;
import com.maven.bourbon_backend.service.ProfileService;
import com.maven.bourbon_backend.service.RefreshService;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class ProfileControllerTest {

    @Mock
    private ProfileService profileService;
    @Mock
    private RefreshService refreshService;
    private ProfileController underTest;

    @BeforeEach
    void setUp(){
        underTest = new ProfileController(profileService, refreshService);
    }

    @Test
    void canAddRole() {
        //given
        Role role = new Role("1", "user");
        //when
        underTest.addRole(role);
        //then
        ArgumentCaptor<Role> roleArgumentCaptor = ArgumentCaptor.forClass(Role.class);
        verify(profileService).addRole(roleArgumentCaptor.capture());
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
        verify(profileService).addProfile(profileArgumentCaptor.capture());
        Profile capturedProfile = profileArgumentCaptor.getValue();
        assertThat(capturedProfile).isEqualTo(profile);
    }

    @Test
    void canGetAllProfiles() {
        //when
        underTest.getAllProfiles();
        //then
        verify(profileService).getAllProfiles();
    }

    @Test
    void canGetProfileById() {
        //given
        String identification = "Id";
        //when
        underTest.getProfileById(identification);
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(profileService).getProfileById(stringArgumentCaptor.capture());
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
        verify(profileService).deleteProfileById(stringArgumentCaptor.capture());
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
        verify(profileService).updateProfileById(stringArgumentCaptor.capture(), profileArgumentCaptor.capture());
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
        String identification = "Id";
        String testName = "testName";
        List<String> testBourbons = new ArrayList<>();
        testBourbons.add("1920");
        Role role = new Role("1", "user");
        Collection<Role> testRoles = new ArrayList<>();
        testRoles.add(role);
        Profile profile = new Profile(identification, testName, "testPassword", testBourbons , testRoles);
        //when
        underTest.getBourbonsOnProfile(identification);
        //then
        ArgumentCaptor<Profile> profileArgumentCaptor = ArgumentCaptor.forClass(Profile.class);
        verify(profileService).getBourbonsOnProfile(profileArgumentCaptor.capture());
        Profile capturedProfile = profileArgumentCaptor.getValue();
        assertThat(capturedProfile).isEqualTo(identification);
    }

    @Test
    void canGetProfilesByBourbon() {
        //given
        String identification = "Id";
        //when
        underTest.getProfilesByBourbon(identification);
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(profileService).getAllProfilesForABourbon(stringArgumentCaptor.capture());
        String capturedString = stringArgumentCaptor.getValue();
        assertThat(capturedString).isEqualTo(identification);
    }

    @Test
    @Disabled
    void refreshAuth() {
    }

    @Test
    @Disabled
    void logout() {
    }

    @Test
    void canGetProfileByName() {
        //given
        String testName = "testName";
        //when
        underTest.getProfileByName(testName);
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(profileService).getProfileByName(stringArgumentCaptor.capture());
        String capturedString = stringArgumentCaptor.getValue();
        assertThat(capturedString).isEqualTo(testName);
    }

    @Test
    void canCheckProfileByName() {
        //given
        String testName = "testName";
        //when
        underTest.getProfileByName(testName);
        //then
        ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
        verify(profileService).getProfileByName(stringArgumentCaptor.capture());
        String capturedString = stringArgumentCaptor.getValue();
        assertThat(capturedString).isEqualTo(testName);
    }
}
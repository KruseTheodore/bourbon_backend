package com.maven.bourbon_backend.repositories;

import com.maven.bourbon_backend.model.Profile;
import com.maven.bourbon_backend.model.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataMongoTest
@ExtendWith(SpringExtension.class)
@TestPropertySource(properties = "spring.mongodb.embedded.version=3.5.5")
public class MongoDBTest {

    @Test
    void itShouldSaveProfile(@Autowired MongoTemplate mongoTemplate) {
        //given
        String testName = "testName";
        List<String> testBourbons = new ArrayList<>();
        testBourbons.add("1920");
        Role role = new Role("1", "user");
        Collection<Role> testRoles = new ArrayList<>();
        testRoles.add(role);
        Profile profile = new Profile("1", testName, "testPassword", testBourbons , testRoles);

        //when
        mongoTemplate.save(profile, "collection");

        //then
        assertThat(mongoTemplate.findById("1", Profile.class, "collection")).toString().equals(profile.toString());
    }
}

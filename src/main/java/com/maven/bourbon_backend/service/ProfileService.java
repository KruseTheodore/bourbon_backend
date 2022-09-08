package com.maven.bourbon_backend.service;

import com.maven.bourbon_backend.repositories.ProfileRepository;
import com.maven.bourbon_backend.model.Profile;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(@Qualifier("MongoProfile") ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public void addProfile(Profile profile){
        profileRepository.save(profile);
    }

    public List<Profile> getAllProfiles(){
        return profileRepository.findAll();
    }

    public Optional<Profile> getProfileById(String id){
        return profileRepository.findById(id);
    }

    public void deleteProfileById(String id){
        profileRepository.deleteById(id);
    }

    public void updateProfileById(String id, Profile profile){
        profileRepository.deleteById(id);
        profileRepository.save(profile);

    }
}

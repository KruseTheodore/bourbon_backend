package com.maven.bourbon_backend.service;

import com.maven.bourbon_backend.model.Bourbon;
import com.maven.bourbon_backend.repositories.ProfileRepository;
import com.maven.bourbon_backend.model.Profile;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final BourbonService bourbonService;

    public ProfileService(@Qualifier("MongoProfile") ProfileRepository profileRepository, BourbonService bourbonService) {
        this.profileRepository = profileRepository;
        this.bourbonService = bourbonService;
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

    public List<Optional<Bourbon>> getBourbonsOnProfile(Profile profile){
        List<Optional<Bourbon>> bourbons = new ArrayList<>();
        Iterator<String> it = profile.getBourbon_ids().iterator();
        while(it.hasNext()){
            bourbons.add(bourbonService.getBourbonByName(it.next()));
        }
        return bourbons;
    }
}

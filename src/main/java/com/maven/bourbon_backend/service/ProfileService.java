package com.maven.bourbon_backend.service;

import com.maven.bourbon_backend.model.Bourbon;
import com.maven.bourbon_backend.model.Role;
import com.maven.bourbon_backend.repositories.ProfileRepository;
import com.maven.bourbon_backend.model.Profile;
import com.maven.bourbon_backend.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProfileService implements UserDetailsService {

    private final ProfileRepository profileRepository;
    private final RoleRepository roleRepository;
    private final BourbonService bourbonService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Profile profile = profileRepository.findByName(username);
        if(profile == null){
            throw new UsernameNotFoundException("User not found.");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        profile.getRoles().forEach(role -> {authorities.add(new SimpleGrantedAuthority(role.getName()));});
        return new User(profile.getName(), profile.getPassword(), authorities);
    }

    @Autowired
    public ProfileService(@Qualifier("MongoProfile") ProfileRepository profileRepository, @Qualifier("MongoRole") RoleRepository roleRepository, BourbonService bourbonService, PasswordEncoder passwordEncoder) {
        this.profileRepository = profileRepository;
        this.roleRepository = roleRepository;
        this.bourbonService = bourbonService;
        this.passwordEncoder = passwordEncoder;
    }

    public void addRole(Role role){
        roleRepository.save(role);
    }
    public void addProfile(Profile profile){
        profile.setPassword(passwordEncoder.encode(profile.getPassword()));
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

    public List<Profile> getAllProfilesForABourbon (String id){
        return profileRepository.findByBourbonIDs(id);
    }

    public Profile getProfileByName(String name){
        return profileRepository.findByName(name);
    }

    public void addFollow(String name, String followName) {
        List<String> followed = new ArrayList<>();
        System.out.println(followName);
        Profile profile = this.getProfileByName(name);
        if(profile.getFollowed_names() != null){
            followed = profile.getFollowed_names();
        }
        else {
            profile.setFollowed_names(followed);
        }
        followed.add(followName);
        profile.setFollowed_names(followed);
        this.updateProfileById(profile.getId(), profile);
    }

}

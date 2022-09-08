package com.maven.bourbon_backend.api;

import com.maven.bourbon_backend.model.Profile;
import com.maven.bourbon_backend.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("BourbonCommunityReviews/profile")
@RestController
public class ProfileController {

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public void addProfile(@RequestBody Profile profile){
        profileService.addProfile(profile);
    }
    @GetMapping
    public List<Profile> getAllProfiles(){
       return profileService.getAllProfiles();
    }
    @GetMapping(path = "{id}")
    public Optional<Profile> getProfileById(@PathVariable String id){
        return profileService.getProfileById(id);
    }
    @DeleteMapping(path = "{id}")
    public void deleteProfileById(@PathVariable String id){
        profileService.deleteProfileById(id);
    }
    @PutMapping(path = "{id}")
    public void updateProfileById(@PathVariable String id, @RequestBody Profile profile){
        profileService.updateProfileById(id, profile);
    }

}

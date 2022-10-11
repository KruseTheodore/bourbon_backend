package com.maven.bourbon_backend.api;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maven.bourbon_backend.model.Bourbon;
import com.maven.bourbon_backend.model.Profile;
import com.maven.bourbon_backend.model.RefreshToken;
import com.maven.bourbon_backend.model.Role;
import com.maven.bourbon_backend.service.ProfileService;
import com.maven.bourbon_backend.service.RefreshService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.*;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("BourbonCommunityReviews/profile")
@RestController
public class ProfileController {

    private final ProfileService profileService;

    private final RefreshService refreshService;

    @Autowired
    public ProfileController(ProfileService profileService, RefreshService refreshService) {
        this.profileService = profileService;
        this.refreshService = refreshService;
    }

    @PostMapping(path ="/role")
    public void addRole(@RequestBody Role role){
        profileService.addRole(role);
    }
    @PostMapping(path = "/new")
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
    @GetMapping(path = "/bourbons/{id}")
    public List<Optional<Bourbon>> getBourbonsOnProfile(@PathVariable("id") String id){
        return profileService.getBourbonsOnProfile(profileService.getProfileById(id).orElse(null));
    }

    @GetMapping(path = "/profiles/{id}")
    public List<Profile> getProfilesByBourbon(@PathVariable("id") String id){
        return profileService.getAllProfilesForABourbon(id);
    }

    @GetMapping(path = "/refresh")
    public void refreshAuth(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(IF_MATCH);
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try{
                String  refresh_string = authorizationHeader.substring("Bearer ".length());
                RefreshToken refreshToken = new RefreshToken(refresh_string);
                if(refreshService.checkToken(refreshToken)) {
                    Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                    JWTVerifier verifier = JWT.require(algorithm).build();
                    DecodedJWT decodedJWT = verifier.verify(refresh_string);
                    String username = decodedJWT.getSubject();
                    Profile profile = profileService.getProfileByName(username);
                    String access_token = JWT.create()
                            .withSubject(profile.getName())
                            .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                            .withIssuer(request.getRequestURL().toString())
                            .withClaim("roles", profile.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                            .sign(algorithm);

                    Map<String, String> tokens = new HashMap<>();
                    tokens.put("access_token", access_token);
                    tokens.put("refresh_token", refresh_string);
                    response.setContentType(APPLICATION_JSON_VALUE);
                    new ObjectMapper().writeValue(response.getOutputStream(), tokens);
                }
                else{
                    new ObjectMapper().writeValue(response.getOutputStream(), "User Logged Out");
                }
            }
            catch (Exception exception){
                response.setHeader("Error", exception.getMessage());
                response.setStatus(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", exception.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }

        }
        else {
            throw new RuntimeException("No refresh token given.");
        }
    }

    @GetMapping(path = "/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String authorizationHeader = request.getHeader(IF_NONE_MATCH);
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                String  refresh_string = authorizationHeader.substring("Bearer ".length());
                RefreshToken refreshToken = new RefreshToken(refresh_string);
                if(refreshService.checkToken(refreshToken)) {
                    refreshService.deleteToken(refreshToken);
                }
        }
        else {
            throw new RuntimeException("No refresh token given.");
        }
    }

    @GetMapping(path = "/byname/{name}")
    public Profile getProfileByName(@PathVariable String name){
        return profileService.getProfileByName(name);
    }

    @GetMapping(path = "/check/{name}")
    public boolean checkProfileByName(@PathVariable String name){
        if (profileService.getProfileByName(name) == null){
            return true;
        }
        else{
            return false;
        }

    }

    @PostMapping(path = "/follow/{name}/{followName}")
    public void addFollow(@PathVariable String name, @PathVariable String followName){
        profileService.addFollow(name, followName);
    }

    @DeleteMapping(path = "/unfollow/{name}/{followName}")
    public void deleteFollow(@PathVariable String name, @PathVariable String followName){
        profileService.deleteFollow(name, followName);
    }

    @PostMapping(path = "/bourbon/{name}/{bourbonName}")
    public void addBourbon(@PathVariable String name, @PathVariable String bourbonName){
        profileService.addBourbon(name, bourbonName);
    }

    @DeleteMapping(path = "/unbourbon/{name}/{bourbonName}")
    public void deleteBourbon(@PathVariable String name, @PathVariable String bourbonName){
        profileService.deleteBourbon(name, bourbonName);
    }


}

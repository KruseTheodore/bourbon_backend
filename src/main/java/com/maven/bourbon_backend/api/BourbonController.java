package com.maven.bourbon_backend.api;

import com.maven.bourbon_backend.model.Bourbon;
import com.maven.bourbon_backend.service.BourbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("BourbonCommunityReviews/bourbon")
@RestController
public class BourbonController {

    private final BourbonService bourbonService;

    @Autowired
    public BourbonController(BourbonService bourbonService){
        this.bourbonService = bourbonService;
    }

    @PostMapping
    public void addBourbon(@RequestBody Bourbon bourbon) {
        bourbonService.addBourbon(bourbon);
    }

    @GetMapping
    public ResponseEntity<List<Bourbon>> getAllBourbons(){
        List<Bourbon> bourbons = bourbonService.getAllBourbons();
        return new ResponseEntity<>(bourbons, HttpStatus.OK) ;
    }

    @GetMapping(path = "{name}")
    public Optional<Bourbon> getBourbonByName(@PathVariable("name")String name){
        return bourbonService.getBourbonByName(name);
    }

    @DeleteMapping(path = "{name}")
    public void deleteBourbonByName(@PathVariable("name") String name){
        bourbonService.deleteBourbonByName(name);
    }

    @PutMapping(path = "{name}")
    public void updateBourbonByName(@PathVariable("name") String name, @RequestBody Bourbon bourbon){
        bourbonService.updateBourbonById(name, bourbon);
    }

}

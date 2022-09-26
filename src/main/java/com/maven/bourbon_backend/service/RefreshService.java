package com.maven.bourbon_backend.service;

import com.maven.bourbon_backend.model.RefreshToken;
import com.maven.bourbon_backend.repositories.RefreshRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RefreshService {
    private final RefreshRepository refreshRepository;

    @Autowired
    public RefreshService(RefreshRepository refreshRepository) {
        this.refreshRepository = refreshRepository;
    }

    public void saveToken(RefreshToken refreshToken){
        refreshRepository.save(refreshToken);
    }

    public void deleteToken(RefreshToken refreshToken){
        refreshRepository.delete(refreshToken);
    }

    public boolean checkToken(RefreshToken refreshToken){
        if(refreshRepository.existsById(refreshToken.getToken())){
            return true;
        }
        else{
            return false;
        }
    }
}

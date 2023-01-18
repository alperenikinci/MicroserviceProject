package com.alperenikinci.service;

import com.alperenikinci.exception.ErrorType;
import com.alperenikinci.exception.UserProfileMicroserviceException;
import com.alperenikinci.repository.IUserProfileRepository;
import com.alperenikinci.repository.entity.UserProfile;
import com.alperenikinci.utility.ServiceManager;
import com.fasterxml.jackson.annotation.OptBoolean;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService extends ServiceManager<UserProfile,String> {

    private final IUserProfileRepository userProfileRepository;

    public List<UserProfile> findAll(Long authId){
        Optional<UserProfile> userProfile = userProfileRepository.findOptionalByAuthId(authId);
        if(userProfile.isEmpty())
            throw new UserProfileMicroserviceException(ErrorType.UNAUTHORIZED_REQUEST);
        return findAll();
    }
    public UserProfileService(IUserProfileRepository repository) {
        super(repository);
        this.userProfileRepository=repository;
    }

    @Cacheable(value = "getuppercase")
    public String getUpperCase(String name) {
        try {
            Thread.sleep(3000L);
        } catch (Exception exception) {

        }
        return name.toUpperCase();
    }
    @CacheEvict(cacheNames = "getuppercase", allEntries = true)
    public void clearCache(){
        System.out.println("Belleği temizledim.");
    }
}

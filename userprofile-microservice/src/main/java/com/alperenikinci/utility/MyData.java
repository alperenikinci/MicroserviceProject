package com.alperenikinci.utility;

import com.alperenikinci.dto.request.UserProfileSaveRequestDto;
import com.alperenikinci.manager.IUserProfileElasticService;
import com.alperenikinci.repository.IUserProfileRepository;
import com.alperenikinci.repository.entity.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class MyData {

    private final IUserProfileRepository repository;
    private final IUserProfileElasticService manager;

    @PostConstruct
    public void init(){
        List<UserProfile> plist = repository.findAll();
        plist.forEach(u ->{
            manager.save(UserProfileSaveRequestDto.builder()
                            .username(u.getUsername())
                            .authId(u.getAuthId())
                            .profileImage(u.getProfileImage())
                            .userId(u.getId())
                    .build());
        });
    }

}

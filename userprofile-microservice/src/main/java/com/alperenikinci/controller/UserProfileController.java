package com.alperenikinci.controller;

import com.alperenikinci.dto.request.BaseRequestDto;
import com.alperenikinci.dto.request.CreateProfileRequestDto;
import com.alperenikinci.repository.entity.UserProfile;
import com.alperenikinci.service.UserProfileService;
import com.alperenikinci.utility.TokenGenerator;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.alperenikinci.constants.RestApi.*;

@RestController
@RequestMapping(USERPROFILE)
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileService userProfileService;
    private final TokenGenerator tokenGenerator;



    @PostMapping(GETALL)
    public ResponseEntity<List<UserProfile>> userProfilesList(@RequestBody @Valid BaseRequestDto dto){
        Long authId = tokenGenerator.decodeToken(dto.getToken());
        return ResponseEntity.ok(userProfileService.findAll(authId));
    }

    /**
     * DİKKAT!!!
     * mutlaka @RequestBody ve @Valid eklentilerini yap.
     * @param dto
     * @return
     */
    @PostMapping(CREATEPROFILE)
    public ResponseEntity<Boolean> createProfile(@RequestBody @Valid CreateProfileRequestDto dto){
        userProfileService.save(UserProfile.builder()
                        .authId(dto.getAuthId())
                        .email(dto.getEmail())
                        .username(dto.getUsername())
                        .build());;
        return ResponseEntity.ok(true);
    }

    @GetMapping(GETALL)
    public ResponseEntity<List<UserProfile>> userProfilesList(){
        return ResponseEntity.ok(userProfileService.findAll());
    }

    @GetMapping("/getupper")
    public ResponseEntity<String> getUpperCase(String name){
        return ResponseEntity.ok(userProfileService.getUpperCase(name));
    }

    @GetMapping("/clear")
    public ResponseEntity<Void> clearAll(){
        userProfileService.clearCache();
        return ResponseEntity.ok().build();
    }



}

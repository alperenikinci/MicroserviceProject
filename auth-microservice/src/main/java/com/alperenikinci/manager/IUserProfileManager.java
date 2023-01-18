package com.alperenikinci.manager;

import com.alperenikinci.dto.request.CreateProfileRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * isimlendirme benzersiz unique olmalıdır.
 */
@FeignClient(name = "user-profile-manager"
        , url = "${myapplication.user.feignUrl}"
        , decode404 = true)
public interface IUserProfileManager {

    @PostMapping("/createprofile")
    ResponseEntity<Boolean> createProfile(@RequestBody @Valid CreateProfileRequestDto dto);
}

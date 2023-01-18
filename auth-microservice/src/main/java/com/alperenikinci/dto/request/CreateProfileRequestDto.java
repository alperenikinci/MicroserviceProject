package com.alperenikinci.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateProfileRequestDto {

    @NotNull
    Long authId;
    @NotBlank
    String username;
    @NotBlank
    @Email
    String email;
    String token;

}

package com.alperenikinci.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserProfileSaveRequestDto {

    String userId;
    Long authId;
    String username;
    String profileImage;


}

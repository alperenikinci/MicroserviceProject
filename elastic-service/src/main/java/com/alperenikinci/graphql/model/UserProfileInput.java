package com.alperenikinci.graphql.model;

import lombok.Data;
@Data
public class UserProfileInput {
    Long authId;
    String username;
    String profileImage;
}

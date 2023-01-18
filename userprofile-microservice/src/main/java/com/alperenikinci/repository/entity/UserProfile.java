package com.alperenikinci.repository.entity;

import com.alperenikinci.utility.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@Document
public class UserProfile extends BaseEntity {

    @Id
    String id;

    /**
     * Auth Microservice'de kayıt olan bir kullanıcının id bilgisini tutar.
     */
    Long authId;
    String username;
    String email;
    String phone;
    String address;
    String profileImage;
    String avatar;
    String info;
    String facebook;
    String twitter;
    String instagram;


}

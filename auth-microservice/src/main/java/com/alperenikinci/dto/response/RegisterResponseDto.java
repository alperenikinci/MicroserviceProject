package com.alperenikinci.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegisterResponseDto {

    Long authId;
    String content;
    String email;
    /**
     * 100- Kayıt başarılı
     * 200- Kayıt beklemede
     * 300- hata
     * 400- parametre hataları
     */
    Integer registerState;
}

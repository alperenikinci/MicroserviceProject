package com.alperenikinci.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tbl_auth")
@Entity
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    String email;
    Long createDate;
    Long updateDate;
    /**
     * Enum yapılarında, int değeri ya da String değerini
     * seçmek için kullanırız.
     */
    @Enumerated(EnumType.STRING)
    State state;
}

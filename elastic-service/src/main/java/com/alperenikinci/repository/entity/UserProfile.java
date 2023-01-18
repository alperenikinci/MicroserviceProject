package com.alperenikinci.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(indexName = "userprofile")
public class UserProfile {
/**
 * Elasticsearch bir db gibi davranacağı için tuttuğu datalara id vermesi olasıdır.
 * ayrıca indexleme gibi işlemler içinde gereklidir.
 * Bu nedenle isteğe bağlı olarak önbellek aldığınız dbnin id bilgisini ayıt edebileceğiniz gibi
 * bu işlemi elasticsearch te yapabilir.
 */
    @Id
    String id;
    String userId;
    Long authId;
    String username;
    String profileImage;


}

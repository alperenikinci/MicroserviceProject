package com.alperenikinci.graphql.mutation;

import com.alperenikinci.graphql.model.UserProfileInput;
import com.alperenikinci.repository.entity.UserProfile;
import com.alperenikinci.service.UserProfileService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserProfileMutationResolver implements GraphQLMutationResolver {

    private final UserProfileService userProfileService;

    public Boolean createUserProfile(UserProfileInput input){
        userProfileService.save(UserProfile.builder()
                        .username(input.getUsername())
                        .authId(input.getAuthId())
                        .profileImage(input.getProfileImage())
                        .userId(UUID.randomUUID().toString())
                .build());
        return true;
    }

}

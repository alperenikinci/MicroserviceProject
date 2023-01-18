package com.alperenikinci.mapper;

import com.alperenikinci.dto.request.UserProfileSaveRequestDto;
import com.alperenikinci.repository.entity.UserProfile;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserProfileMapper {

    IUserProfileMapper INSTANCE = Mappers.getMapper(IUserProfileMapper.class);
    UserProfile fromUserProfileDto(final UserProfileSaveRequestDto dto);
}

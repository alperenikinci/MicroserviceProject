package com.alperenikinci.mapper;

import com.alperenikinci.dto.request.RegisterRequestDto;
import com.alperenikinci.dto.response.RegisterResponseDto;
import com.alperenikinci.repository.entity.Auth;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface IAuthMapper {

        IAuthMapper INSTANCE = Mappers.getMapper(IAuthMapper.class);
        Auth fromRegisterRequestDto(final RegisterRequestDto dto);

        @Mappings({
                @Mapping(source = "id", target = "authId"),
        })
        RegisterResponseDto fromAuth(final Auth auth);


}

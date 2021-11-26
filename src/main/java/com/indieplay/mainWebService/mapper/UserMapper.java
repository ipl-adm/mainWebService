package com.indieplay.mainWebService.mapper;

import com.indieplay.mainWebService.domain.entity.User;
import com.indieplay.mainWebService.dto.SignUpRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(SignUpRequest request);
}

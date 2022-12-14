package com.hau.huylong.graduation_proejct.service.mapper;

import com.hau.huylong.graduation_proejct.entity.auth.User;
import com.hau.huylong.graduation_proejct.model.dto.auth.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO to(User entity);

    @Mapping(target = "id", ignore = true)
    User from(UserDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "email", ignore = true)
    User copy(UserDTO dto, @MappingTarget User entity);
}

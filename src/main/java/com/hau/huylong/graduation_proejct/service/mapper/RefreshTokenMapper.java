package com.hau.huylong.graduation_proejct.service.mapper;

import com.hau.huylong.graduation_proejct.entity.auth.RefreshToken;
import com.hau.huylong.graduation_proejct.model.dto.auth.RefreshTokenDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {})
public interface RefreshTokenMapper {
    @Mapping(target = "id", ignore = true)
    RefreshToken from(RefreshTokenDTO dto);

    RefreshTokenDTO to(RefreshToken entity);

    @Mapping(target = "id", ignore = true)
    RefreshToken copy(RefreshTokenDTO dto, @MappingTarget RefreshToken entity);
}

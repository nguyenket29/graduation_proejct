package com.hau.huylong.graduation_proejct.service.mapper;

import com.hau.huylong.graduation_proejct.entity.hau.UserInfo;
import com.hau.huylong.graduation_proejct.model.dto.auth.UserInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserInfoMapper {
    UserInfoDTO to(UserInfo entity);

    @Mapping(target = "id", ignore = true)
    UserInfo from(UserInfoDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "companyId", ignore = true)
    UserInfo copy(UserInfoDTO dto, @MappingTarget UserInfo entity);
}

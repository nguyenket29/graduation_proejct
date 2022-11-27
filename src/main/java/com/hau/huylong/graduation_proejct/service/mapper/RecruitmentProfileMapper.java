package com.hau.huylong.graduation_proejct.service.mapper;

import com.hau.huylong.graduation_proejct.entity.hau.RecruitmentProfile;
import com.hau.huylong.graduation_proejct.model.dto.hau.RecruitmentProfileDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecruitmentProfileMapper extends EntityMapper<RecruitmentProfileDTO, RecruitmentProfile> {
}

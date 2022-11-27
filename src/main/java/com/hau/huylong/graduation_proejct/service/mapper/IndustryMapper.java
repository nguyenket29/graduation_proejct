package com.hau.huylong.graduation_proejct.service.mapper;

import com.hau.huylong.graduation_proejct.entity.hau.Industries;
import com.hau.huylong.graduation_proejct.model.dto.hau.IndustryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IndustryMapper extends EntityMapper<IndustryDTO, Industries> {
}

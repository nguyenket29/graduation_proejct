package com.hau.huylong.graduation_proejct.service.mapper;

import com.hau.huylong.graduation_proejct.entity.hau.Post;
import com.hau.huylong.graduation_proejct.model.dto.hau.PostDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper extends EntityMapper<PostDTO, Post> {
}

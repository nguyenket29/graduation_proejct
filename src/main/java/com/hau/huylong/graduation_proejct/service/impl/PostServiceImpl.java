package com.hau.huylong.graduation_proejct.service.impl;

import com.hau.huylong.graduation_proejct.entity.hau.Post;
import com.hau.huylong.graduation_proejct.model.dto.hau.PostDTO;
import com.hau.huylong.graduation_proejct.model.response.PageDataResponse;
import com.hau.huylong.graduation_proejct.repository.hau.PostReps;
import com.hau.huylong.graduation_proejct.service.PostService;
import com.hau.huylong.graduation_proejct.service.mapper.PostMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PostServiceImpl implements PostService {
    private final PostReps postReps;
    private final PostMapper postMapper;

    @Override
    public PostDTO save(PostDTO postDTO) {
        return null;
    }

    @Override
    public PostDTO edit(Long id, PostDTO postDTO) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public PostDTO findById(Long id) {
        return null;
    }

    @Override
    public PageDataResponse<PostDTO> getAll(Post request) {
        return null;
    }
}

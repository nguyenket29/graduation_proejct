package com.hau.huylong.graduation_proejct.controller.hau;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hau.huylong.graduation_proejct.controller.APIController;
import com.hau.huylong.graduation_proejct.model.dto.hau.PostDTO;
import com.hau.huylong.graduation_proejct.model.request.SearchPostRequest;
import com.hau.huylong.graduation_proejct.model.response.APIResponse;
import com.hau.huylong.graduation_proejct.model.response.PageDataResponse;
import com.hau.huylong.graduation_proejct.service.PostService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@AllArgsConstructor
@Api(value = "API bài viết")
public class PostController extends APIController<PostDTO, SearchPostRequest> {
    private final PostService postService;

    @Override
    public ResponseEntity<APIResponse<PostDTO>> save(@RequestBody PostDTO postDTO) throws JsonProcessingException {
        return ResponseEntity.ok(APIResponse.success(postService.save(postDTO)));
    }

    @Override
    public ResponseEntity<APIResponse<PostDTO>> edit(Long id, @RequestBody PostDTO postDTO) {
        return ResponseEntity.ok(APIResponse.success(postService.edit(id, postDTO)));
    }

    @Override
    public ResponseEntity<APIResponse<Void>> delete(Long id) {
        postService.delete(id);
        return ResponseEntity.ok(APIResponse.success());
    }

    @Override
    public ResponseEntity<APIResponse<PostDTO>> findById(Long id) {
        return ResponseEntity.ok(APIResponse.success(postService.findById(id)));
    }

    @Override
    public ResponseEntity<APIResponse<PageDataResponse<PostDTO>>> getAll(SearchPostRequest request) {
        return ResponseEntity.ok(APIResponse.success(postService.getAll(request)));
    }
}

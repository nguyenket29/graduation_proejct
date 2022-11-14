package com.hau.huylong.graduation_proejct.controller.hau;

import com.hau.huylong.graduation_proejct.model.dto.auth.UserDTO;
import com.hau.huylong.graduation_proejct.model.request.UserRequest;
import com.hau.huylong.graduation_proejct.model.response.APIResponse;
import com.hau.huylong.graduation_proejct.model.response.PageDataResponse;
import com.hau.huylong.graduation_proejct.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@CrossOrigin
public class UserController  {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<APIResponse<PageDataResponse<UserDTO>>> getAll(UserRequest request) {
        return ResponseEntity.ok(APIResponse.success(userService.getAll(request)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponse<UserDTO>> edit(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(APIResponse.success(userService.edit(id, userDTO)));
    }
}

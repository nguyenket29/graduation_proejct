package com.hau.huylong.graduation_proejct.service;

import com.hau.huylong.graduation_proejct.entity.auth.User;
import com.hau.huylong.graduation_proejct.model.dto.auth.UserDTO;
import com.hau.huylong.graduation_proejct.model.request.UserRequest;
import com.hau.huylong.graduation_proejct.model.response.PageDataResponse;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsernameAndStatus(String username, short status);
    PageDataResponse<UserDTO> getAll(UserRequest request);
    UserDTO edit(Integer userId, UserDTO userDTO);
}

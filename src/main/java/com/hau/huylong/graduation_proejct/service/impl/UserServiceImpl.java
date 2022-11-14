package com.hau.huylong.graduation_proejct.service.impl;

import com.hau.huylong.graduation_proejct.common.exception.APIException;
import com.hau.huylong.graduation_proejct.common.util.PageableUtils;
import com.hau.huylong.graduation_proejct.entity.auth.Role;
import com.hau.huylong.graduation_proejct.entity.auth.User;
import com.hau.huylong.graduation_proejct.model.dto.auth.UserDTO;
import com.hau.huylong.graduation_proejct.model.request.UserRequest;
import com.hau.huylong.graduation_proejct.model.response.PageDataResponse;
import com.hau.huylong.graduation_proejct.repository.auth.RoleReps;
import com.hau.huylong.graduation_proejct.repository.auth.UserReps;
import com.hau.huylong.graduation_proejct.service.UserService;
import com.hau.huylong.graduation_proejct.service.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserReps userReps;
    private final RoleReps roleReps;

    /**
     * Tìm kiếm người dùng theo username và status
     *
     * @Param: username
     * @Param: status
     * @Return: User
     * */
    @Override
    @Cacheable("users")
    public Optional<User> findByUsernameAndStatus(String username, short status) {
        log.info("calling findByUsernameAndStatus");
        return userReps.findByUsernameAndStatus(username, status);
    }

    /**
     * Danh sách người dùng
     *
     * @Param: request
     * @Return: PageDataResponse<UserDTO>
     *
     * */
    @Override
    public PageDataResponse<UserDTO> getAll(UserRequest request) {
        Pageable pageable = PageableUtils.of(request.getPage(), request.getSize());
        Page<UserDTO> pageData = userReps.search(pageable).map(userMapper::to);
        return PageDataResponse.of(pageData);
    }

    /**
     * Chỉnh sửa người dùng
     *
     * @Param: userId
     * @RequestBody: UserDTO
     * @Return: UserDTO
     * */
    @Override
    public UserDTO edit(Integer userId, UserDTO userDTO) {
        Optional<User> userOptional = userReps.findById(userId);

        if (userOptional.isEmpty()) {
            throw APIException.from(HttpStatus.NOT_FOUND).withMessage("Không thể tìm thấy người dùng với id  " + userOptional);
        }

        List<Role> roles = roleReps.findByCodes(userDTO.getListRole());
        Set<Role> roleSet = new HashSet<>(roles);
        User user = userOptional.get();
        user.setRoles(roleSet);

        String oldEmail = user.getEmail();
        userMapper.copy(userDTO, user);
        user.setEmail(oldEmail);
        return userMapper.to(userReps.save(user));
    }
}

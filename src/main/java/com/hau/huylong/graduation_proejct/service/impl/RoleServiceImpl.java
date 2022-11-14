package com.hau.huylong.graduation_proejct.service.impl;

import com.hau.huylong.graduation_proejct.common.util.PageableUtils;
import com.hau.huylong.graduation_proejct.entity.auth.Role;
import com.hau.huylong.graduation_proejct.model.request.RoleRequest;
import com.hau.huylong.graduation_proejct.model.response.PageDataResponse;
import com.hau.huylong.graduation_proejct.repository.auth.RoleReps;
import com.hau.huylong.graduation_proejct.service.RoleService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class RoleServiceImpl implements RoleService {
    private final RoleReps roleReps;

    @Override
    public PageDataResponse<Role> getAll(RoleRequest request) {
        Pageable pageable = PageableUtils.of(request.getPage(), request.getSize());
        Page<Role> pageData = roleReps.search(pageable);
        return PageDataResponse.of(pageData);
    }
}

package com.hau.huylong.graduation_proejct.service;

import com.hau.huylong.graduation_proejct.entity.auth.Role;
import com.hau.huylong.graduation_proejct.model.request.RoleRequest;
import com.hau.huylong.graduation_proejct.model.response.PageDataResponse;

public interface RoleService {
    PageDataResponse<Role> getAll(RoleRequest request);
}

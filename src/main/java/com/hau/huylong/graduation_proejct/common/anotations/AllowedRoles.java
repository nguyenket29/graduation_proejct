package com.hau.huylong.graduation_proejct.common.anotations;

import com.hau.huylong.graduation_proejct.common.enums.RoleEnums;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface AllowedRoles {
    RoleEnums.Role[] value();
}

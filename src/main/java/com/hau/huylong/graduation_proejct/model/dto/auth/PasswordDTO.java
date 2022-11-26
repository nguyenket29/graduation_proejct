package com.hau.huylong.graduation_proejct.model.dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PasswordDTO {
    private String oldPassword;

    private  String token;

    private String newPassword;

    private String email;
}

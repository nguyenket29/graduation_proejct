package com.hau.huylong.graduation_proejct.model.dto.auth;

import com.hau.huylong.graduation_proejct.model.dto.hau.CompanyDTO;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class UserDTO {
    private Integer id;
    private String username;
    private String password;
    private String confirmPassword;
    private Short status;
    private String email;
    private String type;
    private UserInfoDTO userInfoDTO;
    private CompanyDTO companyDTO;
    private List<String> listRole;
}

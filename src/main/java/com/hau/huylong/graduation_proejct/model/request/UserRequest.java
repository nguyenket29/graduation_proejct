package com.hau.huylong.graduation_proejct.model.request;

import lombok.Data;

import java.util.List;

@Data
public class UserRequest extends SearchRequest{
    private String username;
    private String password;
    private Short status;
    private String email;
    private String type;
    private SearchUserInfoRequest userInfoRequest;
    private SearchCompanyRequest companyRequest;
    private List<String> listRole;
}

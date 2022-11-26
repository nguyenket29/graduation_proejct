package com.hau.huylong.graduation_proejct.model.request;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class UserRequest extends SearchRequest{
    private String username;
    private String password;
    private Short status;
    private String email;
    private String type;
    private String fullName;
    private String avatar;
    private Instant dateOfBirth;
    private String town;
    private short gender;
    private String marriageStatus;
    private String address;
    private String phoneNumber;
    private List<String> listRole;
}

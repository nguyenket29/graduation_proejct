package com.hau.huylong.graduation_proejct.model.request;

import lombok.Data;

import java.time.Instant;

@Data
public class SearchUserInfoRequest {
    private String fullName;
    private String avatar;
    private Instant dateOfBirth;
    private String town;
    private short gender;
    private String marriageStatus;
    private String address;
    private String phoneNumber;
}

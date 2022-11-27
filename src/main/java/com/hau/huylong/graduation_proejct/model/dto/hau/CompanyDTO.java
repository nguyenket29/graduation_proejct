package com.hau.huylong.graduation_proejct.model.dto.hau;

import lombok.Data;

@Data
public class CompanyDTO {
    private Long id;
    private String taxCode;
    private String name;
    private String employeeNumber;
    private String address;
    private String phoneNumber;
    private String fieldOfActivity;
    private Integer userId;
}

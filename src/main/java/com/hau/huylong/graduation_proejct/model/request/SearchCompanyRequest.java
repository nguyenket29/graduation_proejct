package com.hau.huylong.graduation_proejct.model.request;

import lombok.Data;

@Data
public class SearchCompanyRequest extends SearchRequest{
    private String taxCode;
    private String name;
    private String employeeNumber;
    private String address;
    private String phoneNumber;
    private String fieldOfActivity;
}

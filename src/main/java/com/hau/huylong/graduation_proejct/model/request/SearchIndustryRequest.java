package com.hau.huylong.graduation_proejct.model.request;

import lombok.Data;

@Data
public class SearchIndustryRequest extends SearchRequest{
    private String code;
    private String name;
    private String description;
}

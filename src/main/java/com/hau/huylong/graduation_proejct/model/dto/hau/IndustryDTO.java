package com.hau.huylong.graduation_proejct.model.dto.hau;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IndustryDTO {
    private String code;
    private String name;
    private String description;
}

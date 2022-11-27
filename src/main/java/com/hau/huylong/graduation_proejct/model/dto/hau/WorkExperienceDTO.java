package com.hau.huylong.graduation_proejct.model.dto.hau;

import lombok.Data;

import java.time.Instant;

@Data
public class WorkExperienceDTO {
    private String regency;
    private String companyName;
    private Instant fromWorkTime;
    private Instant toWorkTime;
    private String description;
}

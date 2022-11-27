package com.hau.huylong.graduation_proejct.model.dto.hau;

import lombok.Data;

import java.time.Instant;

@Data
public class AcademyInfoDTO {
    private String addressAcademy;
    private String specialize;
    private String certificateName;
    private Instant timeFrom;
    private Instant timeTo;
}

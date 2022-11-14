package com.hau.huylong.graduation_proejct.model.dto.hau;

import lombok.Data;

import java.io.Serializable;

@Data
public class GoogleDriverFileDTO implements Serializable {
    private String id;
    private String name;
    private String link;
    private String size;
    private String thumbnailLink;
    private boolean shared;
}

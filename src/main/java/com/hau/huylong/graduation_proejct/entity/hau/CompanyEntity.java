package com.hau.huylong.graduation_proejct.entity.hau;

import com.hau.huylong.graduation_proejct.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "company")
public class CompanyEntity extends BaseEntity {
    // mã số thuế
    private String taxCode;
    private String name;
    private String personNumber;
    private String address;
    private String phoneNumber;
    private String fieldOfActivity;
}

package com.hau.huylong.graduation_proejct.entity.auth;

import com.hau.huylong.graduation_proejct.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "reset_password_token")
@Data
public class ResetPasswordToken extends BaseEntity {
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "token", nullable = false, unique = true)
    private String token;

    @Column(name = "expiry_date")
    private Date expiryDate;
}

package com.hau.huylong.graduation_proejct.service;

import com.hau.huylong.graduation_proejct.entity.auth.UserVerification;

import java.util.Optional;

public interface UserVerificationService {
    Optional<UserVerification> findByCode(String code);
    Optional<UserVerification> findByUserId(Integer userId);
    void save(Integer userId, String code);
}

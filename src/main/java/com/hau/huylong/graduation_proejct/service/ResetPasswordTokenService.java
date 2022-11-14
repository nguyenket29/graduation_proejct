package com.hau.huylong.graduation_proejct.service;

import com.hau.huylong.graduation_proejct.entity.auth.ResetPasswordToken;

import java.util.Optional;

public interface ResetPasswordTokenService {
    boolean createTokenResetPassword(Integer userId, String  token);
    String validatePasswordResetToken(String token);

    Optional<ResetPasswordToken> findByToken(String token);
}

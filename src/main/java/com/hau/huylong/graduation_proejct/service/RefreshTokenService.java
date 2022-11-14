package com.hau.huylong.graduation_proejct.service;

import com.hau.huylong.graduation_proejct.model.dto.auth.RefreshTokenDTO;

import java.util.Optional;

public interface RefreshTokenService {
    Optional<RefreshTokenDTO> findByRefreshToken(String token);
    Optional<RefreshTokenDTO> findByAccessToken(String accessToken);
    Optional<RefreshTokenDTO> findByUserId(Integer id);
    RefreshTokenDTO createRefreshToken(Integer userId, String accessToken);
    RefreshTokenDTO verifyExpiration(RefreshTokenDTO token);

    RefreshTokenDTO update(RefreshTokenDTO dto);
}

package com.hau.huylong.graduation_proejct.repository.auth;

import com.hau.huylong.graduation_proejct.entity.auth.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenReps extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByRefreshToken(String token);
    Optional<RefreshToken> findByUserIdAndAccessToken(Integer userId, String accessToken);
    Optional<RefreshToken> findByUserId(Integer userId);
    Optional<RefreshToken> findByAccessToken(String accToken);
}

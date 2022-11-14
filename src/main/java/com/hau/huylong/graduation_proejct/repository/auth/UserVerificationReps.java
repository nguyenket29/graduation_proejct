package com.hau.huylong.graduation_proejct.repository.auth;

import com.hau.huylong.graduation_proejct.entity.auth.UserVerification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserVerificationReps extends CrudRepository<UserVerification, Long> {
    Optional<UserVerification> findByCode(String code);
    Optional<UserVerification> findByUserId(Integer userId);
}

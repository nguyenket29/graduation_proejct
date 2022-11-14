package com.hau.huylong.graduation_proejct.service.impl;

import com.hau.huylong.graduation_proejct.entity.auth.UserVerification;
import com.hau.huylong.graduation_proejct.repository.auth.UserVerificationReps;
import com.hau.huylong.graduation_proejct.service.UserVerificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class UserVerificationServiceImpl implements UserVerificationService {
    private final UserVerificationReps userVerificationReps;

    @Override
    public Optional<UserVerification> findByCode(String code) {
        return userVerificationReps.findByCode(code);
    }

    @Override
    public Optional<UserVerification> findByUserId(Integer userId) {
        return userVerificationReps.findByUserId(userId);
    }

    @Override
    @Transactional
    public void save(Integer userId, String code) {
        UserVerification userVerification = new UserVerification();
        userVerification.setUserId(userId);
        userVerification.setCode(code);
        userVerification.setStatus(UserVerification.Status.UN_ACTIVE);
        //set expire date to 12h
        userVerification.setExpireDate(calculateExpireDate(12 * 60));
        userVerificationReps.save(userVerification);
    }

    //calculate expiry date
    private Date calculateExpireDate(int expireTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, expireTime);
        return calendar.getTime();
    }
}

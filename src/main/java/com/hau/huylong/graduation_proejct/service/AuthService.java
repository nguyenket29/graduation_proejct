package com.hau.huylong.graduation_proejct.service;

import com.hau.huylong.graduation_proejct.model.dto.auth.UserDTO;
import com.hau.huylong.graduation_proejct.model.request.SignupRequest;
import com.hau.huylong.graduation_proejct.model.request.TokenRefreshRequest;
import com.hau.huylong.graduation_proejct.model.response.TokenRefreshResponse;
import com.hau.huylong.graduation_proejct.model.response.UserResponse;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthService {
    TokenRefreshResponse refreshToken(TokenRefreshRequest request);
    UserResponse getInfo();
    void logout(HttpServletRequest request, HttpServletResponse response);
    UserDTO signup(SignupRequest signupRequest, HttpServletRequest request);
    boolean verifyAccount(String code);
    void forgotPassword(String email, HttpServletRequest request) throws MessagingException;

    boolean updatePassword(String newPassword, String token, String oldPassword);
}

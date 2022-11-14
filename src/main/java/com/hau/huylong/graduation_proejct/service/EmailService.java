package com.hau.huylong.graduation_proejct.service;

import com.hau.huylong.graduation_proejct.model.dto.auth.UserDTO;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface EmailService {
    void sendMail(UserDTO userDTO, HttpServletRequest request) throws MessagingException;
    void sendEmail(String subject, Map<String, Object> variables, String pathFile, String fileName, UserDTO userDTO) throws MessagingException;
}

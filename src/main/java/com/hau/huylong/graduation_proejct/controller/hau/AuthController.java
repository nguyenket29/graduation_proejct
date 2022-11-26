package com.hau.huylong.graduation_proejct.controller.hau;

import com.hau.huylong.graduation_proejct.model.dto.auth.PasswordDTO;
import com.hau.huylong.graduation_proejct.model.dto.auth.UserDTO;
import com.hau.huylong.graduation_proejct.model.request.SignupRequest;
import com.hau.huylong.graduation_proejct.model.request.TokenRefreshRequest;
import com.hau.huylong.graduation_proejct.model.response.APIResponse;
import com.hau.huylong.graduation_proejct.model.response.TokenRefreshResponse;
import com.hau.huylong.graduation_proejct.model.response.UserResponse;
import com.hau.huylong.graduation_proejct.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/refresh-token")
    public ResponseEntity<APIResponse<TokenRefreshResponse>> tokenRefresh(@RequestBody TokenRefreshRequest request) {
        return ResponseEntity.ok(APIResponse.success(authService.refreshToken(request)));
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<APIResponse<Void>> forgotPassword(@RequestBody PasswordDTO passwordDTO, HttpServletRequest request) throws MessagingException {
        authService.forgotPassword(passwordDTO.getEmail(), request);
        return ResponseEntity.ok(APIResponse.success());
    }

    @PostMapping("/update-password")
    public ResponseEntity<APIResponse<Boolean>> updatePassword(@RequestBody PasswordDTO passwordDTO) {
        return ResponseEntity.ok(APIResponse
                .success(authService.updatePassword(passwordDTO.getNewPassword(), passwordDTO.getToken(), passwordDTO.getOldPassword())));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<APIResponse<UserDTO>> signup(@RequestBody @Valid SignupRequest request, HttpServletRequest servletRequest) {
        return ResponseEntity.ok(APIResponse.success(authService.signup(request, servletRequest)));
    }

    @GetMapping("/activation")
    public ResponseEntity<APIResponse<Boolean>> verifyAccount(@RequestParam String code) {
        return ResponseEntity.ok(APIResponse.success(authService.verifyAccount(code)));
    }

    @GetMapping("/account")
    public ResponseEntity<APIResponse<UserResponse>> getAccountInfo() {
        return ResponseEntity.ok(APIResponse.success(authService.getInfo()));
    }

    @PostMapping("/log-out")
    public ResponseEntity<APIResponse<Void>> logout(HttpServletRequest request, HttpServletResponse response) {
        authService.logout(request, response);
        return ResponseEntity.ok(APIResponse.success());
    }
}

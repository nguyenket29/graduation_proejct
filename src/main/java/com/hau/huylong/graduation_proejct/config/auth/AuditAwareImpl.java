package com.hau.huylong.graduation_proejct.config.auth;

import com.hau.huylong.graduation_proejct.common.constant.Constants;
import com.hau.huylong.graduation_proejct.entity.auth.CustomUser;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;
import java.util.Optional;

public class AuditAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (Objects.isNull(authentication)) {
            return Optional.of(Constants.ANONYMOUS);
        }
        Object principal = authentication.getPrincipal();
        if (Objects.isNull(principal)) {
            return Optional.of(Constants.ANONYMOUS);
        }
        if (principal instanceof CustomUser) {
            return Optional.of(((CustomUser) principal).getUsername());
        }
        return Optional.of(Constants.ANONYMOUS);
    }
}

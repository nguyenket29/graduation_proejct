package com.hau.huylong.graduation_proejct.common.anotations;

import com.hau.huylong.graduation_proejct.common.constant.Constants;
import com.hau.huylong.graduation_proejct.common.enums.RoleEnums;
import com.hau.huylong.graduation_proejct.common.exception.APIException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Aspect
@Component
public class AllowedRolesAspect {

    @Around("@annotation(com.hau.huylong.graduation_proejct.common.anotations.AllowedRoles)")
    public Object doSomething(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!Objects.equals(authentication.getName(), Constants.ADMIN)) {
            Set<RoleEnums.Role> roles = Arrays.stream(((MethodSignature) proceedingJoinPoint.getSignature()).getMethod()
                    .getAnnotation(AllowedRoles.class).value()).collect(Collectors.toSet());

            HttpServletRequest request = getRequest();

            for (RoleEnums.Role role : roles) {
                if (Objects.nonNull(request)) {
                    if (request.isUserInRole(role.name())) {
                        return proceedingJoinPoint.proceed();
                    }
                }
            }

            throw APIException.from(HttpStatus.FORBIDDEN).withMessage("Access Denied!");
        }
        return proceedingJoinPoint.proceed();
    }

    private HttpServletRequest getRequest() {
        ServletRequestAttributes servletRequestAttributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return Objects.nonNull(servletRequestAttributes) ? servletRequestAttributes.getRequest() : null;
    }
}

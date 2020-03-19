package com.cwd.tg.gss.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import reactor.core.publisher.Mono;

@Slf4j
public class SecurityUtils {

    public static Mono<AuthHeaders> getAuthHeaders() {
        return getSecurityContext()
                .map(securityContext -> securityContext.getAuthentication())
                .map(Authentication::getCredentials)
                .cast(AuthHeaders.class)
                .doOnSuccess(authHeaders -> log.info("Auth headers: {}", authHeaders));
    }

    private static Mono<SecurityContext> getSecurityContext() {
        return ReactiveSecurityContextHolder.getContext();
    }
}

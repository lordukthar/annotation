package com.example.demo;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Aspect
@Component
public class LoggedInAspect {

    @Autowired
    private AuthenticationService authenticationService;

    @Before("@annotation(loggedIn)")
    public Mono<Void> checkLoggedIn(ServerWebExchange exchange, LoggedIn loggedIn) {
        String sessionToken = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (sessionToken == null || !authenticationService.isValidSession(sessionToken)) {
            return Mono.error(new SecurityException("User must be logged in to access this method"));
        }
        return Mono.empty();
    }
}

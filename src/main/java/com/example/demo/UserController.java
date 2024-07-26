package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @LoggedIn
    @GetMapping("/details")
    public Mono<String> getUserDetails() {
        return Mono.just(userService.getUserDetails());
    }

    @GetMapping("/public-info")
    public Mono<String> getPublicInfo() {
        return Mono.just(userService.getPublicInfo());
    }
}


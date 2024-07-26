package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getUserDetails() {
        // Business logic here
        return "User details";
    }

    public String getPublicInfo() {
        // Public information logic here
        return "Public information";
    }
}


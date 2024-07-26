package com.example.demo;




import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AuthenticationService {

    private final ConcurrentHashMap<String, String> sessionCache = new ConcurrentHashMap<>();

    public String login(String username, String password) {
        // Perform authentication (this example accepts any username/password)
        if (username != null && password != null) {
            String sessionToken = UUID.randomUUID().toString();
            sessionCache.put(sessionToken, username);
            return sessionToken;
        }
        throw new SecurityException("Invalid username or password");
    }

    public boolean isValidSession(String sessionToken) {
        return sessionCache.containsKey(sessionToken);
    }
}



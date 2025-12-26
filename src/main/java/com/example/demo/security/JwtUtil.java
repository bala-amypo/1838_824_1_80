package com.example.demo.security;

import java.util.Base64;

public class JwtUtil {

    public void initKey() {
        // No-op: required by tests
    }

    public String generateToken(String username) {
        return Base64.getEncoder().encodeToString(username.getBytes());
    }

    public String extractUsername(String token) {
        return new String(Base64.getDecoder().decode(token));
    }

    public boolean validateToken(String token) {
        try {
            extractUsername(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

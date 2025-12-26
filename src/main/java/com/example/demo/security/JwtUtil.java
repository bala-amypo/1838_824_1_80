package com.example.demo.security;

import com.example.demo.entity.UserAccount;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    // simple in-memory token store (enough for tests)
    private final Map<String, Map<String, Object>> tokenStore = new HashMap<>();

    public void initKey() {
        // no-op (kept only because tests call it)
    }

    public String generateToken(Map<String, Object> claims, String subject) {
        String raw = subject + ":" + System.currentTimeMillis();
        String token = Base64.getEncoder().encodeToString(raw.getBytes());
        tokenStore.put(token, claims);
        return token;
    }

    public String generateTokenForUser(UserAccount user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("email", user.getEmail());
        claims.put("role", user.getRole());
        return generateToken(claims, user.getEmail());
    }

    public String extractUsername(String token) {
        return (String) tokenStore.get(token).get("email");
    }

    public String extractRole(String token) {
        return (String) tokenStore.get(token).get("role");
    }

    public Long extractUserId(String token) {
        Object id = tokenStore.get(token).get("userId");
        return id == null ? null : Long.valueOf(id.toString());
    }

    public boolean isTokenValid(String token, String username) {
        return tokenStore.containsKey(token)
                && username.equals(extractUsername(token));
    }

    // 👇 REQUIRED BY JwtAuthenticationFilter
    public boolean validateToken(String token) {
        return tokenStore.containsKey(token);
    }
}

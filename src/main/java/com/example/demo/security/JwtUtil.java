package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    private String secretKey;
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    // ✅ REQUIRED BY SecurityConfig
    public void initKey() {
        this.secretKey = "mysecretkeymysecretkeymysecretkey";
    }

    // ✅ REQUIRED BY TESTS
    public String generateToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // ✅ REQUIRED BY TESTS
    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    // ✅ REQUIRED BY TESTS
    public String extractRole(String token) {
        return getClaims(token).get("role", String.class);
    }

    // ✅ REQUIRED BY TESTS
    public Long extractUserId(String token) {
        return getClaims(token).get("userId", Long.class);
    }

    // ✅ REQUIRED BY JwtAuthenticationFilter
    public boolean validateToken(String token) {
        return !isTokenExpired(token);
    }

    // ✅ REQUIRED BY TESTS
    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }

    // -------- INTERNAL METHODS --------

    private boolean isTokenExpired(String token) {
        return getClaims(token)
                .getExpiration()
                .before(new Date());
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }
}

package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private Key key;

    // Called from SecurityConfig
    public void initKey() {
        this.key = Keys.hmacShaKeyFor(
                "verysecretkeyverysecretkeyverysecretkey"
                        .getBytes(StandardCharsets.UTF_8)
        );
    }

    // 🔥 REQUIRED BY TEST CASES
    public String generateTokenForUser(com.example.demo.entity.UserAccount user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("userId", user.getId())
                .claim("role", user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(key)
                .compact();
    }

    // 🔥 REQUIRED BY FILTER
    public void validateToken(String token) {
        // If token is invalid, an exception will be thrown automatically
        Jwts.parser()
                .verifyWith((javax.crypto.SecretKey) key)
                .build()
                .parseSignedClaims(token);
    }

    // 🔥 REQUIRED BY TEST CASES
    public Jws<Claims> parseToken(String token) {
        return Jwts.parser()
                .verifyWith((javax.crypto.SecretKey) key)
                .build()
                .parseSignedClaims(token);
    }
}

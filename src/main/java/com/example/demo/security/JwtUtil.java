package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

public class JwtUtil {

    private Key key;

    public void initKey() {
        this.key = Keys.hmacShaKeyFor(
                "verysecretkeyverysecretkeyverysecretkey"
                        .getBytes(StandardCharsets.UTF_8)
        );
    }

    // Used by tests
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

    // Used by filter
    public void validateToken(String token) {
        Jwts.parser()
                .verifyWith((javax.crypto.SecretKey) key)
                .build()
                .parseSignedClaims(token);
    }

    // Used by tests
    public Jws<Claims> parseToken(String token) {
        return Jwts.parser()
                .verifyWith((javax.crypto.SecretKey) key)
                .build()
                .parseSignedClaims(token);
    }
}

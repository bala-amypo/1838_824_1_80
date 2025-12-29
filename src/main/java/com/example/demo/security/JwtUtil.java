package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JwtUtil {

    private Key key;

    public void initKey() {
        this.key = Keys.hmacShaKeyFor(
                "verysecretkeyverysecretkeyverysecretkey".getBytes(StandardCharsets.UTF_8)
        );
    }

    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String generateTokenForUser(com.example.demo.entity.UserAccount ua) {
        return generateToken(
                Map.of(
                        "userId", ua.getId(),
                        "email", ua.getEmail(),
                        "role", ua.getRole()
                ),
                ua.getEmail()
        );
    }

    public boolean isTokenValid(String token, String email) {
        return extractUsername(token).equals(email);
    }

    public String extractUsername(String token) {
        return parseToken(token).getPayload().getSubject();
    }

    public Long extractUserId(String token) {
        return ((Number) parseToken(token).getPayload().get("userId")).longValue();
    }

    public String extractRole(String token) {
        return (String) parseToken(token).getPayload().get("role");
    }

    public Jws<Claims> parseToken(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
    }
}

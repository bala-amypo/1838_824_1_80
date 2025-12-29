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

    // REQUIRED by JwtAuthenticationFilter
    public boolean validateToken(String token) {
        try {
            parseToken(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isTokenValid(String token, String email) {
        return extractUsername(token).equals(email);
    }

    public String extractUsername(String token) {
        return parseToken(token).getBody().getSubject();
    }

    public Long extractUserId(String token) {
        return ((Number) parseToken(token).getBody().get("userId")).longValue();
    }

    public String extractRole(String token) {
        return (String) parseToken(token).getBody().get("role");
    }

    // IMPORTANT: getBody(), NOT getPayload()
    public Jws<Claims> parseToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }
}

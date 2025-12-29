package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    private static final String SECRET_KEY =
            "mysecretkeymysecretkeymysecretkeymysecretkey";

    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    private SecretKey key;

    // =====================================================
    // Initialization (called from SecurityConfig)
    // =====================================================
    public void initKey() {
        this.key = Keys.hmacShaKeyFor(
                SECRET_KEY.getBytes(StandardCharsets.UTF_8)
        );
    }

    // =====================================================
    // Token Generation
    // =====================================================
    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .claims(claims)
                .subject(subject)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // ✅ REQUIRED BY TESTS
    public String generateTokenForUser(UserAccount user) {
        return generateToken(
                Map.of(
                        "userId", user.getId(),
                        "role", user.getRole()
                ),
                user.getEmail()
        );
    }

    // =====================================================
    // Token Parsing (TESTS EXPECT Jws<Claims>)
    // =====================================================
    public Jws<Claims> parseToken(String token) {
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token);
    }

    // =====================================================
    // Helpers
    // =====================================================
    public String extractUsername(String token) {
        return parseToken(token).getPayload().getSubject();
    }

    public String extractRole(String token) {
        return parseToken(token).getPayload().get("role", String.class);
    }

    public Long extractUserId(String token) {
        return parseToken(token).getPayload().get("userId", Long.class);
    }

    // =====================================================
    // Validation (REQUIRED BY JwtAuthenticationFilter)
    // =====================================================
    public boolean validateToken(String token) {
        try {
            parseToken(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isTokenValid(String token, String subject) {
        try {
            Claims claims = parseToken(token).getPayload();
            return claims.getSubject().equals(subject)
                    && claims.getExpiration().after(new Date());
        } catch (Exception e) {
            return false;
        }
    }
}

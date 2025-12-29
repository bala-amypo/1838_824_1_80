package com.example.demo.security;

import com.example.demo.entity.UserAccount;
import io.jsonwebtoken.Claims;
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
    public String generateToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .claims(claims)
                .subject(username)
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
                user.getUsername()
        );
    }

    // =====================================================
    // Token Parsing
    // =====================================================
    public Claims parseToken(String token) {
        return extractAllClaims(token);
    }

    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    public String extractRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

    public Long extractUserId(String token) {
        return extractAllClaims(token).get("userId", Long.class);
    }

    // =====================================================
    // Validation
    // =====================================================
    public boolean validateToken(String token) {
        return !isTokenExpired(token);
    }

    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }

    // =====================================================
    // Internal Helpers (JJWT 0.12.x API)
    // =====================================================
    private boolean isTokenExpired(String token) {
        return extractAllClaims(token)
                .getExpiration()
                .before(new Date());
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(key)          // 🔑 REQUIRED IN 0.12.x
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}

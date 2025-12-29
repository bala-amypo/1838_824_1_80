package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    private static final String SECRET_KEY =
            "mysecretkeymysecretkeymysecretkeymysecretkey";

    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    private Key key;

    // ✅ Called from SecurityConfig
    public void initKey() {
        this.key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    // ✅ Used by tests
    public String generateToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // ✅ Used by tests
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    // ✅ Used by tests
    public String extractRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

    // ✅ Used by tests
    public Long extractUserId(String token) {
        return extractAllClaims(token).get("userId", Long.class);
    }

    // ✅ Used by JwtAuthenticationFilter
    public boolean validateToken(String token) {
        return !isTokenExpired(token);
    }

    // ✅ Used by tests
    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }

    // ---------- INTERNAL HELPERS ----------

    private boolean isTokenExpired(String token) {
        return extractAllClaims(token)
                .getExpiration()
                .before(new Date());
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()                // 🔑 REQUIRED STEP
                .parseClaimsJws(token) // now called on JwtParser
                .getBody();
    }
}

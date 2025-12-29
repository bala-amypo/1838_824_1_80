package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.*;

public class JwtUtil {

    private Key key;

    public void initKey() {
        key = Keys.hmacShaKeyFor(
            "verysecretkeyverysecretkeyverysecretkey".getBytes(StandardCharsets.UTF_8)
        );
    }

    public String generateTokenForUser(com.example.demo.entity.UserAccount u) {
        return Jwts.builder()
                .setSubject(u.getEmail())
                .claim("userId", u.getId())
                .claim("role", u.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(key)
                .compact();
    }

    public Jws<Claims> parseToken(String token) {
        return Jwts.parser()
                .verifyWith((javax.crypto.SecretKey) key)
                .build()
                .parseSignedClaims(token);
    }
}

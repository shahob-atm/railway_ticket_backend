package com.example.railway_ticket_backend.service.jwt;

import com.example.railway_ticket_backend.entity.user.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {

    @Value("${secretKey}")
    private String secretKey;

    @Override
    public String generateJwtToken(User user) {
        Map<String, String> claims = Map.of("id", user.getId().toString(), "username", user.getUsername());
        return Jwts.builder()
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .claims(claims)
                .subject(user.getId().toString())
                .signWith(signWithKey()).compact();
    }

    @Override
    public String extractJwtToken(String token) {
        Jws<Claims> claimsJws = Jwts.parser().verifyWith(signWithKey())
                .build().parseSignedClaims(token);
        return claimsJws.getPayload().getSubject();
    }

    SecretKey signWithKey() {
        byte[] decode = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(decode);
    }
}

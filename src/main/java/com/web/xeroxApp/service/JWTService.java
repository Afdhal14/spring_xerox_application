package com.web.xeroxApp.service;

import com.web.xeroxApp.model.Users;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.Jwts;


@Service
public class JWTService {

    private String secretKey = "";

    public JWTService()
    {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("hmacSHA256");
            SecretKey sk = keyGen.generateKey();
            secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


    public String generateToken(Users user)
    {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role",user.getRole().name());
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+60*60*300))
                .and()
                .signWith(getKey())
                .compact();
    }

    public SecretKey getKey()
    {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}

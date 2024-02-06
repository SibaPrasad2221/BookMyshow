package com.book_my_show.Book.My.Show.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class JWTService {
    public static final String secretKey ="sahoo";
    public String extractUserName(String token){
        return
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimResolver){
        //this function shows what kind of claim you want to extract
    }

    public Claims extractAllClaims(String token){
//        return Jwts.parser().
    }
}

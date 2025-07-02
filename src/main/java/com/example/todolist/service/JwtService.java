package com.example.todolist.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.example.todolist.entity.UsuarioEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtService {
	private static final String SECRET_KEY = "626B6971627075767778797A7E7F808182838485868788898A8B8C8D8E8F9091";

	public String generateToken(UsuarioEntity usuarioEntity) {

		return Jwts.builder()

				.setClaims(new HashMap<>()).setSubject(usuarioEntity.getEmail())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
				.signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
	}

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);

	}

	public boolean isTokenValid(String token, UsuarioEntity usuario) {

		final String username = extractUsername(token);
		return (username.equals(usuario.getEmail())) && !isTokenExpired(token);

	}
 
	private boolean isTokenExpired(String token) {

		return extractClaim(token, Claims::getExpiration).before(new Date());

	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {

		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);

	}

	private Claims extractAllClaims(String token) {

		return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();

	}
	
	private Key getSignKey () {
		
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
		
	}

}

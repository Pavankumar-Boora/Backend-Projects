package com.learning.util;

import java.io.IOException;

import java.util.Date;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil {

	private String jwtSecret = "qG9jciM8OpZfDmrA2QbxJifqSrf5Y0TbD8U+3GfTXSA=";

	public String generateToken(String userName) {
		return Jwts.builder().setSubject(userName).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 654000000))
				.signWith(SignatureAlgorithm.HS256, jwtSecret).compact();
	}

	public Boolean validateToken(String token, String username) {
		final String extractedUsername = extractUsername(token);
		return (extractedUsername.equals(username) && !isTokenExpired(token));
	}

	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).build().parseClaimsJws(token).getBody();
	}

}

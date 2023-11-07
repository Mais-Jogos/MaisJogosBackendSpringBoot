package com.br.maisjogos.config.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.br.maisjogos.entity.Desenvolvedor;
@Service
public class TokenServiceDev {
	@Value("${api.security.token.secret}")
	private String secreat;
	
	public String generateToken(Desenvolvedor principal) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secreat);
			String tokenString = JWT.create()
					.withIssuer("auth-api")
					.withSubject(principal.getLogin())
					.withExpiresAt(genExpirationDate())
					.sign(algorithm);
			return tokenString;
		} catch (JWTCreationException exception) {
			throw new RuntimeException("Erro ao gerar o token", exception);
		}
	}

	public String validateToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secreat);
			return JWT.require(algorithm)
					.withIssuer("auth-api")
					.build()
					.verify(token)
					.getSubject();
					
		} catch (JWTVerificationException exception) {
			
			return "";
		}
	}
	
	private Instant genExpirationDate() {
		
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
}

package br.com.fiap.fiap_ds.config.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.fiap.fiap_ds.model.Usuario;

@Component
public class JwtUtil {

	private String palavraSecreta = "KEY_FIAP_APPLICATION";

	public String gerarToken(Usuario usuario) {

		try {
			Algorithm algorithm = Algorithm.HMAC256(palavraSecreta);

			String token = JWT.create().withIssuer("monitoramento").withSubject(usuario.getEmail())
					.withClaim("role", usuario.getRole().toUpperCase()).withExpiresAt(gerarDataDeExpiracao())
					.sign(algorithm);

			return token;
		} catch (JWTCreationException e) {
			throw new RuntimeException("Não foi possível gerar o token!");
		}

	}

	private Instant gerarDataDeExpiracao() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}

	public String validarToken(String token) {

		try {
			Algorithm algorithm = Algorithm.HMAC256(palavraSecreta);

			return JWT.require(algorithm).withIssuer("monitoramento").build().verify(token).getSubject();

		} catch (JWTVerificationException e) {
			return "";
		}
	}

}
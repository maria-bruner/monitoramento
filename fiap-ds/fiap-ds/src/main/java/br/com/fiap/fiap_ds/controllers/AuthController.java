package br.com.fiap.fiap_ds.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.fiap_ds.config.security.JwtUtil;
import br.com.fiap.fiap_ds.model.Usuario;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Usuario usuario) {
	    try {
	        UsernamePasswordAuthenticationToken usernamePassword = 
	            new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getSenha());
	        
	        Authentication auth = authenticationManager.authenticate(usernamePassword);
	        
	        String token = jwtUtil.gerarToken(usuario);
	        
	        return ResponseEntity.ok(token);
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(500).body("Erro de autenticação: " + e.getMessage());
	    }
	}

}
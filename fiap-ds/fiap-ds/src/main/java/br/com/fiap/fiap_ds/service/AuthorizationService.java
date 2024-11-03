package br.com.fiap.fiap_ds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.fiap.fiap_ds.repositories.UsuarioRepository;

@Service
public class AuthorizationService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserDetails userDetails = usuarioRepository.findByEmail(email);

		if (userDetails == null) {
			throw new UsernameNotFoundException("Usuário não encontrado: " + email);
		}

		return userDetails;
	}
}
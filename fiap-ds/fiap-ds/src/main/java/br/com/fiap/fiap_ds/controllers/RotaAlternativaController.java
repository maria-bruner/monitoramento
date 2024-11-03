package br.com.fiap.fiap_ds.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.fiap_ds.model.RotaAlternativa;
import br.com.fiap.fiap_ds.repositories.RotaAlternativaRepository;

@RestController
@RequestMapping("/api/rota-alternativa")
public class RotaAlternativaController {

	@Autowired
	private RotaAlternativaRepository rotaRepository;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping
	public ResponseEntity<?> listarRotas() {
		return ResponseEntity.ok(rotaRepository.findAll());
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping
	public ResponseEntity<?> criarRota(@RequestBody RotaAlternativa rota) {
		rotaRepository.save(rota);
		return ResponseEntity.ok("Rota criada com sucesso");
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/buscar")
	public ResponseEntity<List<RotaAlternativa>> buscarRotasPorLocalizacao(@RequestParam String localizacaoAtual) {
		List<RotaAlternativa> rotas = rotaRepository.findByLocalizacaoAtual(localizacaoAtual);
		return ResponseEntity.ok(rotas);
	}
}
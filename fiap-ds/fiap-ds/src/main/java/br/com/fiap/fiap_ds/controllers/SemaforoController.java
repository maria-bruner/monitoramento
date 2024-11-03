package br.com.fiap.fiap_ds.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.fiap_ds.model.Semaforo;
import br.com.fiap.fiap_ds.repositories.SemaforoRepository;

@RestController
@RequestMapping("/api/semaforo")
public class SemaforoController {

	@Autowired
	private SemaforoRepository semaforoRepository;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<?> criarSemaforo(@RequestBody Semaforo semaforo) {
        semaforoRepository.save(semaforo);
        return ResponseEntity.ok("Semaforo registrado com sucesso.");
    }
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PatchMapping("/{id}")
	public ResponseEntity<Semaforo> atualizarTempoVerdeSemaforo(@PathVariable Long id, @RequestParam int qtdVeiculos) {
		Semaforo semaforo = semaforoRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		semaforo.setQtdVeiculo(qtdVeiculos);

		if (qtdVeiculos > 10) {
			semaforo.setTempoVerde(semaforo.getTempoVerde() + 10);
		}

		Semaforo updatedLight = semaforoRepository.save(semaforo);
		return ResponseEntity.ok(updatedLight);
	}
}
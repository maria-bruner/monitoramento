package br.com.fiap.fiap_ds.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.fiap_ds.model.Acidente;
import br.com.fiap.fiap_ds.repositories.AcidenteRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/acidente")
public class AcidenteController {

    @Autowired
    private AcidenteRepository acidenteRepository;

    @PostMapping
    public ResponseEntity<?> registrarAcidente(@Valid @RequestBody Acidente acidente) {
        acidenteRepository.save(acidente);
        return ResponseEntity.ok("Acidente identificado com sucesso!");
    }

    @GetMapping
    public ResponseEntity<List<Acidente>> listarAcidentes() {
        List<Acidente> acidentes = acidenteRepository.findAll();
        return ResponseEntity.ok(acidentes);
    }
    
    @GetMapping("/data/{data}")
    public ResponseEntity<List<Acidente>> buscarAcidentesPorDia(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        LocalDateTime inicioDoDia = data.atStartOfDay();
        LocalDateTime fimDoDia = data.atTime(23, 59, 59);

        List<Acidente> acidentes = acidenteRepository.findByDataBetween(inicioDoDia, fimDoDia);
        return ResponseEntity.ok(acidentes);
    }
}
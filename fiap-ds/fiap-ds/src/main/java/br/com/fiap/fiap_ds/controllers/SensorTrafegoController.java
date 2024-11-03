package br.com.fiap.fiap_ds.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.fiap_ds.model.SensorTrafego;
import br.com.fiap.fiap_ds.repositories.SensorTrafegoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/sensor-manutencao")
public class SensorTrafegoController {

    @Autowired
    private SensorTrafegoRepository sensorRepository;

    @PostMapping
    public ResponseEntity<?> criarSensor(@Valid @RequestBody SensorTrafego sensor) {
    	sensorRepository.save(sensor);
    	return ResponseEntity.ok("Sensor criado com sucesso.");
    }
    
    @GetMapping("/status")
    public ResponseEntity<List<SensorTrafego>> buscarSensoresPorStatus(@RequestParam String status) {
        List<SensorTrafego> sensores = sensorRepository.findByStatus(status);
        return ResponseEntity.ok(sensores);
    }
}
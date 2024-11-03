package br.com.fiap.fiap_ds.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.fiap_ds.model.SensorTrafego;

@Repository
public interface SensorTrafegoRepository extends JpaRepository<SensorTrafego, Long>{

	 List<SensorTrafego> findByStatus(String status);
}
package br.com.fiap.fiap_ds.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.fiap_ds.model.Acidente;

@Repository
public interface AcidenteRepository extends JpaRepository<Acidente, Long>{

	  List<Acidente> findByDataBetween(LocalDateTime inicio, LocalDateTime fim);
}
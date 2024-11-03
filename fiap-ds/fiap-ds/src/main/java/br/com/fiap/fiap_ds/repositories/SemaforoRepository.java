package br.com.fiap.fiap_ds.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.fiap_ds.model.Semaforo;

@Repository
public interface SemaforoRepository extends JpaRepository<Semaforo, Long> {

}
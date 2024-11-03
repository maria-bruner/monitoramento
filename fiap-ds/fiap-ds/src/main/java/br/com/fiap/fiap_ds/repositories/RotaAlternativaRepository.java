package br.com.fiap.fiap_ds.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.fiap_ds.model.RotaAlternativa;

@Repository
public interface RotaAlternativaRepository extends JpaRepository<RotaAlternativa, Long>{

	 List<RotaAlternativa> findByLocalizacaoAtual(String localizacaoAtual);
}
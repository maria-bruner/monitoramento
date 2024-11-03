package br.com.fiap.fiap_ds.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "acidentes")
@AllArgsConstructor
@NoArgsConstructor
public class Acidente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACIDENTE")
//	@SequenceGenerator(name = "SEQ_ACIDENTE", sequenceName = "SEQ_ACIDENTE", allocationSize = 1)
	@Column(name = "id_acidente")
	private Long idAcidente;

	@NotNull
	@Column(name = "localizacao")
	private String localizacao;

	@NotNull
	@Column(name = "data_acidente")
	private LocalDateTime data;

	@NotNull
	@Column(name = "qtd_veiculo")
	private int qtdVeiculo;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Long getIdAcidente() {
		return idAcidente;
	}

	public void setIdAcidente(Long idAcidente) {
		this.idAcidente = idAcidente;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public int getQtdVeiculo() {
		return qtdVeiculo;
	}

	public void setQtdVeiculo(int qtdVeiculo) {
		this.qtdVeiculo = qtdVeiculo;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
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
@Table(name = "sensor_trafego")
@AllArgsConstructor
@NoArgsConstructor
public class SensorTrafego {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sensor_trafego")
	private Long idSensorTrafego;

	@NotNull
	@Column(name = "localizacao")
	private String localizacao;

	@NotNull
	@Column(name = "status")
	private String status;

	@Column(name = "ultimo_ativo")
	private LocalDateTime ultimoAtivo;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Long getIdSensorTrafego() {
		return idSensorTrafego;
	}

	public void setIdSensorTrafego(Long idSensorTrafego) {
		this.idSensorTrafego = idSensorTrafego;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getUltimoAtivo() {
		return ultimoAtivo;
	}

	public void setUltimoAtivo(LocalDateTime ultimoAtivo) {
		this.ultimoAtivo = ultimoAtivo;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
package br.com.fiap.fiap_ds.model;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rotas")
@AllArgsConstructor
@NoArgsConstructor
public class RotaAlternativa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rota")
	private Long idRota;

	@Column(name = "localizacao_atual")
	private String localizacaoAtual;

	@Column(name = "destino")
	private String destino;

	@ElementCollection
	@CollectionTable(name = "rota_boqueios", joinColumns = @JoinColumn(name = "id_rota"))
	@Column(name = "local_bloqueado")
	private List<String> locaisBloqueados;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Long getIdRota() {
		return idRota;
	}

	public void setIdRota(Long idRota) {
		this.idRota = idRota;
	}

	public String getLocalizacaoAtual() {
		return localizacaoAtual;
	}

	public void setLocalizacaoAtual(String localizacaoAtual) {
		this.localizacaoAtual = localizacaoAtual;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public List<String> getLocaisBloqueados() {
		return locaisBloqueados;
	}

	public void setLocaisBloqueados(List<String> locaisBloqueados) {
		this.locaisBloqueados = locaisBloqueados;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
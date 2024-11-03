package br.com.fiap.fiap_ds.model;

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
@Table(name = "semaforos")
@AllArgsConstructor
@NoArgsConstructor
public class Semaforo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEMAFORO")
//  @SequenceGenerator(name = "SEQ_SEMAFORO", sequenceName = "SEQ_SEMAFORO", allocationSize = 1)
    @Column(name = "id_semaforo")
    private Long idSemaforo;

    @NotNull
    @Column(name = "localizacao")
    private String localizacao;

    @NotNull
    @Column(name = "tempo_verde")
    private int tempoVerde;

    @Column(name = "qtd_veiculo")
    private int qtdVeiculo;
    
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

	public Long getIdSemaforo() {
		return idSemaforo;
	}

	public void setIdSemaforo(Long idSemaforo) {
		this.idSemaforo = idSemaforo;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public int getTempoVerde() {
		return tempoVerde;
	}

	public void setTempoVerde(int tempoVerde) {
		this.tempoVerde = tempoVerde;
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
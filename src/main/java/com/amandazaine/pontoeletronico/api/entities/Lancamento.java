package com.amandazaine.pontoeletronico.api.entities;

import java.time.LocalDate;

import com.amandazaine.pontoeletronico.api.enums.TipoEnum;

import jakarta.persistence.*;

@Entity
@Table(name = "lancamento")
public class Lancamento {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_lancamento;
	
	@Column(name = "data", nullable = false)
	private LocalDate data;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "localizacao")
	private String localizacao;
	
	@Column(name = "data_criacao", nullable = false)
	private LocalDate dataCriacao;
	
	@Column(name = "data_atualizacao", nullable = false)
	private LocalDate dataAtualizacao;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false)
	private TipoEnum tipo;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionario_id", nullable = false)
	private Funcionario funcionario;

	public Lancamento() {
	}

	public Long getId_lancamento() {
		return id_lancamento;
	}

	public void setId_lancamento(Long id_lancamento) {
		this.id_lancamento = id_lancamento;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDate getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDate dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public TipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoEnum tipo) {
		this.tipo = tipo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	@PreUpdate //Executa um método antes de atualizar (UPDATE) uma entidade.
	public void preUpdate() {
		dataAtualizacao = LocalDate.now();
	}

	@PrePersist //Executa um método antes de persistir (INSERT) uma entidade.
	public void prePersist() {
		final LocalDate atual = LocalDate.now();
		dataCriacao = atual;
		dataAtualizacao = atual;
	}

	@Override
	public String toString() {
		return "Lancamento{" +
				"id_lancamento=" + id_lancamento +
				", data=" + data +
				", descricao='" + descricao + '\'' +
				", localizacao='" + localizacao + '\'' +
				", dataCriacao=" + dataCriacao +
				", dataAtualizacao=" + dataAtualizacao +
				", tipo=" + tipo +
				", funcionario=" + funcionario +
				'}';
	}
}

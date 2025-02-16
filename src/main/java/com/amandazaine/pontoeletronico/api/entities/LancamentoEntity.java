package com.amandazaine.pontoeletronico.api.entities;

import java.time.LocalDate;

import com.amandazaine.pontoeletronico.api.enums.TipoEnum;

import jakarta.persistence.*;

@Entity
@Table(name = "lancamento")
public class LancamentoEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
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
    @JoinColumn(name = "funcionario_id", nullable = false) //Cria a chave estrangeira funcionario_id na tabela lancamento
	private FuncionarioEntity funcionario;

	public LancamentoEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public FuncionarioEntity getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioEntity funcionario) {
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
				"id_lancamento=" + id +
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

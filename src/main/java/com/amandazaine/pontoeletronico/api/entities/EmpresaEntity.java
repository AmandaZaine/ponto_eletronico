package com.amandazaine.pontoeletronico.api.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresa")
public class EmpresaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "razao_social", nullable = false)
	private String razaoSocial;
	
	@Column(nullable = false)
	private String cnpj;

	//Mapeado automaticamente como TIMESTAMP ou DATE no banco
	//Se precisar de uma conversão específica, pode usar @Convert com um AttributeConverter.
	@Column(name = "data_criacao")
	private LocalDate dataCriacao;

	//Mapeado automaticamente como TIMESTAMP ou DATE no banco
	@Column(name = "data_atualizacao")
	private LocalDate dataAtualizacao;
	
	@OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<FuncionarioEntity> funcionarioEntities;
	
	public EmpresaEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public List<FuncionarioEntity> getFuncionarios() {
		return funcionarioEntities;
	}

	public void setFuncionarios(List<FuncionarioEntity> funcionarioEntities) {
		this.funcionarioEntities = funcionarioEntities;
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
}

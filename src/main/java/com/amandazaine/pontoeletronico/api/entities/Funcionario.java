package com.amandazaine.pontoeletronico.api.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.amandazaine.pontoeletronico.api.enums.PerfilEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "funcionario")
public class Funcionario {
		
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_funcionario;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "senha", nullable = false)
	private String senha;
	
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@Column(name = "valor_hora", precision = 10, scale = 2, columnDefinition = "NUMERIC(10,2)")
	private BigDecimal valorHora;
	
	@Column(name = "qtdd_horas_trabalho_dia")
	private Float qtddHorasTrabalhoDia;
	
	@Column(name = "qtdd_horas_almoco")
	private Float qtddHorasAlmoco;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "perfil", nullable = false)
	private PerfilEnum perfil;
	
	@Column(name = "data_criacao", nullable = false)
	private LocalDate dataCriacao;
	
	@Column(name = "data_atualizacao", nullable = false)
	private LocalDate dataAtualizacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Empresa empresa;

	@OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Lancamento> lancamentos;

	public Funcionario() {
	}

	public Long getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(Long id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public BigDecimal getValorHora() {
		return valorHora;
	}

	//@Transient é usada para indicar que um atributo não deve ser persistido no banco de dados.
	//Isso significa que o JPA ignorará esse campo ao salvar ou recuperar a entidade.
	@Transient
	public Optional<BigDecimal> getValorHoraOpt() {
		return Optional.ofNullable(valorHora);
	}

	public void setValorHora(BigDecimal valorHora) {
		this.valorHora = valorHora;
	}

	public Float getQtddHorasTrabalhoDia() {
		return qtddHorasTrabalhoDia;
	}

	//@Transient é usada para indicar que um atributo não deve ser persistido no banco de dados.
	//Isso significa que o JPA ignorará esse campo ao salvar ou recuperar a entidade.
	@Transient
	public Optional<Float> getQtdHorasTrabalhoDiaOpt() {
		return Optional.ofNullable(qtddHorasTrabalhoDia);
	}

	public void setQtddHorasTrabalhoDia(Float qtddHorasTrabalhoDia) {
		this.qtddHorasTrabalhoDia = qtddHorasTrabalhoDia;
	}

	public Float getQtddHorasAlmoco() {
		return qtddHorasAlmoco;
	}

	//@Transient é usada para indicar que um atributo não deve ser persistido no banco de dados.
	//Isso significa que o JPA ignorará esse campo ao salvar ou recuperar a entidade.
	@Transient
	public Optional<Float> getQtdHorasAlmocoOpt() {
		return Optional.ofNullable(qtddHorasAlmoco);
	}

	public void setQtddHorasAlmoco(Float qtddHorasAlmoco) {
		this.qtddHorasAlmoco = qtddHorasAlmoco;
	}

	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
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
		return "Funcionario{" +
				"id_funcionario=" + id_funcionario +
				", nome='" + nome + '\'' +
				", email='" + email + '\'' +
				", senha='" + senha + '\'' +
				", cpf='" + cpf + '\'' +
				", valorHora=" + valorHora +
				", qtdHorasTrabalhoDia=" + qtddHorasTrabalhoDia +
				", qtdHorasAlmoco=" + qtddHorasAlmoco +
				", perfil=" + perfil +
				", dataCriacao=" + dataCriacao +
				", dataAtualizacao=" + dataAtualizacao +
				", empresa=" + empresa +
				", lancamentos=" + lancamentos +
				'}';
	}
}

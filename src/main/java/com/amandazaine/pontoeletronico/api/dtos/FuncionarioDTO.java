package com.amandazaine.pontoeletronico.api.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.util.Optional;

public class FuncionarioDTO {

    private Long id;

    @NotEmpty(message = "Nome não pode ser vazio.")
    @Length(min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres.")
    private String nome;

    @NotEmpty(message = "Email não pode ser vazio.")
    @Length(min = 5, max = 200, message = "Email deve conter entre 5 e 200 caracteres.")
    @Email(message="Email inválido.")
    private String email;

    private Optional<String> senha = Optional.empty();
    private Optional<String> valorHora = Optional.empty();
    private Optional<String> qtddHorasTrabalhoDia = Optional.empty();
    private Optional<String> qtddHorasAlmoco = Optional.empty();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Optional<String> getSenha() {
        return senha;
    }

    public void setSenha(Optional<String> senha) {
        this.senha = senha;
    }

    public Optional<String> getValorHora() {
        return valorHora;
    }

    public void setValorHora(Optional<String> valorHora) {
        this.valorHora = valorHora;
    }

    public Optional<String> getQtddHorasTrabalhoDia() {
        return qtddHorasTrabalhoDia;
    }

    public void setQtddHorasTrabalhoDia(Optional<String> qtddHorasTrabalhoDia) {
        this.qtddHorasTrabalhoDia = qtddHorasTrabalhoDia;
    }

    public Optional<String> getQtddHorasAlmoco() {
        return qtddHorasAlmoco;
    }

    public void setQtddHorasAlmoco(Optional<String> qtddHorasAlmoco) {
        this.qtddHorasAlmoco = qtddHorasAlmoco;
    }

    @Override
    public String toString() {
        return "FuncionarioDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha=" + senha +
                ", valorHora=" + valorHora +
                ", qtdHorasTrabalhoDia=" + qtddHorasTrabalhoDia +
                ", qtdHorasAlmoco=" + qtddHorasAlmoco +
                '}';
    }
}

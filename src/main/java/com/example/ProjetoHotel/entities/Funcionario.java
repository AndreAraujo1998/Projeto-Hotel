package com.example.ProjetoHotel.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFuncionario", nullable = false, length = 10 )
    @Pattern(regexp ="[0-9]{10}", message = "O codigo de ser um numero inteiro")

    private Integer IdFuncionario;


    @Column(name = "nome", nullable = false, length = 50)
    @Pattern(regexp = "[A-z]{10,50}", message = "O nome deve ter entre 10 e 50 caracteres")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name="telefone")
    private String telefone;

    @Column(name="idSalario")
    private Float idSalario;

    @Column(name= "ativo")
    private Boolean ativo;

    public Integer getIdFuncionario() {
        return IdFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        IdFuncionario = idFuncionario;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Float getIdSalario() {
        return idSalario;
    }

    public void setIdSalario(Float idSalario) {
        this.idSalario = idSalario;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}

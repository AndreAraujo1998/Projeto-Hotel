package com.example.ProjetoHotel.entities;

import javax.persistence.*;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFuncionario")
    public Integer IdFuncionario;

    @Column(name = "nome")
    public String nome;

    @Column(name = "email")
    public String email;

    @Column(name="telefone")
    public String telefone;

    @Column(name="idSalario")
    public Float idSalario;

    @Column(name= "ativo")
    public Boolean ativo;


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

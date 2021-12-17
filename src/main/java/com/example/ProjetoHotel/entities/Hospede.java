package com.example.ProjetoHotel.entities;

import javax.persistence.*;

@Entity
@Table(name = "hospede")
public class Hospede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column Integer idHospede;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "limiteCredito")
    private float limite;

    @Column(name = "idQuarto")
    private Integer idQuarto;

    @Column(name = "ativo")
    private Boolean ativo;

    public Hospede() {
    }

    public Hospede(Integer idHospede, String nome, String email, String telefone, float limite, Integer idQuarto, Boolean ativo) {
        this.idHospede = idHospede;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.limite = limite;
        this.idQuarto = idQuarto;
        this.ativo = ativo;
    }

    public void setId(Integer id) {
        this.idHospede = id;
    }

    public Integer getId() {
        return idHospede;
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

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    public Integer getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(Integer idQuarto) {
        this.idQuarto = idQuarto;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}

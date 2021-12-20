package com.example.ProjetoHotel.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "prato")
public class Prato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPrato", nullable = false, length = 10)
    @Pattern(regexp = "^[0-9]{1,10}$", message = "O código deve ser um número inteiro")
    private Integer idPrato;


    @Column(name = "nomePrato", nullable = false, length = 20)
    @Pattern(regexp = "^[A-Za-z-0-9\s]{1,50}$", message = "O nome do prato deve ter entre 1 e 50 caracteres") //Testando se ponto aceita qualquer coisa
    private String nomePrato;

    @Column(name = "descricao", nullable = false, length = 150)
    @Pattern(regexp = "^[A-Za-z-0-9\s]{1,150}$", message = "A descricao do prato deve ter entre 1 e 150 caracteres")
    private String descricao;

    @Column(name = "valor", nullable = false, length = 10)
    @Pattern(regexp = "^\\d{0,10}(\\,\\d{0,2})?$", message = "O valor do prato deve ter no maximo 10 digitos")
    private Float valor;

    @Column(name= "ativo")
    private Boolean ativo;

    public Integer getIdPrato() {
        return idPrato;
    }

    public void setIdPrato(Integer idPrato) {
        this.idPrato = idPrato;
    }

    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }


    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}

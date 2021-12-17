package com.example.ProjetoHotel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="quarto")
public class Quarto {

    @Id
    @Column (name="idQuarto")
    private Integer idQuarto;
    @Column (name="tamanhoMetros")
    private Float tamanhoMetros;
    @Column (name="nome")
    private String nome;
    @Column (name="precoDia")
    private Float precoDia;
    @Column (name="quantidadePessoas")
    private Integer quantidadePessoas;
    @Column (name="andar")
    private Integer andar;
    @Column (name="numero")
    private Integer numero;
    @Column (name="ativo")
    private Boolean ativo;


    public Integer getIdQuarto() { return idQuarto; }
    public void setIdQuarto(Integer idQuarto) { this.idQuarto = idQuarto; }

    public Float getTamanhoMetros() { return tamanhoMetros; }
    public void setTamanhoMetros(Float tamanhoMetros) { this.tamanhoMetros = tamanhoMetros; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Float getPrecoDia() { return precoDia; }
    public void setPrecoDia(Float precoDia) { this.precoDia = precoDia; }

    public Integer getQuantidadePessoas() { return quantidadePessoas; }
    public void setQuantidadePessoas(Integer quantidadePessoas) { this.quantidadePessoas = quantidadePessoas; }

    public Integer getAndar() { return andar; }
    public void setAndar(Integer andar) { this.andar = andar; }

    public Integer getNumero() { return numero; }
    public void setNumero(Integer numero) { this.numero = numero; }

    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}

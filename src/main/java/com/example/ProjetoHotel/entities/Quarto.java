package com.example.ProjetoHotel.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="quarto")
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="idQuarto", nullable = false, length = 10)
    @Pattern(regexp = "[0-9]{10}]", message = "o codigo deve ser um inteiro")
    private Integer idQuarto;

    @Column (name="tamanhoMetros",nullable = false, length = 20)
    @Pattern(regexp = "^[1-9]\\d*(\\.\\d+)?$", message = "o codigo deve ser um inteiro")
    private Float tamanhoMetros;

    @Column (name="nome",nullable = false, length = 20)
    @Pattern(regexp = "[A-Z]{20}]", message = "o codigo deve ser um inteiro")
    private String nome;

    @Column (name="precoDia",nullable = false, length = 10)
    @Pattern(regexp = "^[1-9]\\d*(\\.\\d+)?$", message = "o codigo deve ser um inteiro")
    private Float precoDia;

    @Column (name="quantidadePessoas",nullable = false, length = 10)
    @Pattern(regexp = "[0-9]{10}]", message = "o codigo deve ser um inteiro")
    private Integer quantidadePessoas;

    @Column (name="andar",nullable = false, length = 10)
    @Pattern(regexp = "[0-9]{10}]", message = "o codigo deve ser um inteiro")
    private Integer andar;

    @Column (name="numero",nullable = false, length = 10)
    @Pattern(regexp = "[0-9]{10}]", message = "o codigo deve ser um inteiro")
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

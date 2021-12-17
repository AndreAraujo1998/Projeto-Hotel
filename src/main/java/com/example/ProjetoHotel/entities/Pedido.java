package com.example.ProjetoHotel.entities;

import javax.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @Column Integer idPedido;

    @Column (name = "idQuarto")
    private Integer idQuarto;

    @Column (name = "valor")
    private double valor;

    @Column (name = "idFuncionario")
    private Integer idFuncionario;

    @Column (name = "ativo")
    private Boolean ativo;

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdQuarto() {
        return idQuarto;
    }

    public void setIdQuarto(Integer idQuarto) {
        this.idQuarto = idQuarto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}

package com.example.ProjetoHotel.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "pedido")
public class Pedido {

    public Integer getIdPedido() {
        return IdPedido;
    }

    public void setIdPedido(Integer idPedido) {
        IdPedido = idPedido;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column  Integer IdPedido;
    @Pattern(regexp = "[0-9]{10}]", message = "o codigo deve ser um inteiro")

    @Column (name = "idQuarto", nullable = false, length = 10)
    @Pattern(regexp = "[0-9]{10}]", message = "o codigo deve ser um inteiro")
    private Integer idQuarto;

    @Column (name = "valor", nullable = false, length = 10)
    @Pattern(regexp = "[0-9]{1,10}]", message = "o codigo deve ser um inteiro")
    private double valor;

    @Column (name = "idFuncionario", nullable = false, length = 10)
    @Pattern(regexp = "[0-9]{10}]", message = "o codigo deve ser um inteiro")
    private Integer idFuncionario;

    @Column (name = "ativo")
    private Boolean ativo;

}

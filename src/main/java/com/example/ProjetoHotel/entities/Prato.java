package com.example.ProjetoHotel.entities;

import javax.persistence.*;

@Entity
@Table(name = "prato")
public class Prato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPrato")
    public Integer idPrato;

    @Column(name = "nomePrato")
    public String nomePrato;

    @Column(name = "descricao")
    public String descricao;

    @Column(name = "valor")
    public Float valor;

    @Column(name = "idPedido")
    public Integer idPedido;



}

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


}

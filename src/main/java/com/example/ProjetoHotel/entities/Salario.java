package com.example.ProjetoHotel.entities;

import javax.persistence.*;

@Entity
@Table(name = "salario")
public class Salario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column Integer id;

    @Column(name = "idFuncionario")
    private Integer idFuncionario;

    @Column(name = "salarioBruto")
    private float salarioBruto;

    @Column(name = "credito")
    private float credito;

    @Column(name = "debito")
    private float debito;

    public Salario() {
    }

    public Salario(Integer id, Integer idFuncionario, float salarioBruto, float credito, float debito) {
        this.id = id;
        this.idFuncionario = idFuncionario;
        this.salarioBruto = salarioBruto;
        this.credito = credito;
        this.debito = debito;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public float getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(float salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public float getCredito() {
        return credito;
    }

    public void setCredito(float credito) {
        this.credito = credito;
    }

    public float getDebito() {
        return debito;
    }

    public void setDebito(float debito) {
        this.debito = debito;
    }
}

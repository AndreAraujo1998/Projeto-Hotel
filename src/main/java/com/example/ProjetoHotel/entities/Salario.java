package com.example.ProjetoHotel.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "salario")
public class Salario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSalario", nullable = false, length = 10)
    @Pattern(regexp = "[0-9]{10}", message = "O código deve ser inteiro")
    private Integer IdSalario;


    @Column(name = "salarioBruto")
    @Pattern(regexp = "[0-9]{1,10}.[0-9]{0,2}", message = "O valor deve ser inserido com . e com duas casas decimais.")
    private float salarioBruto;


    @Column(name = "credito", nullable = false, length = 10)
    @Pattern(regexp = "[0-9]{10}", message = "O código deve ser inteiro")
    private float credito;

    @Column(name = "debito" , nullable = false, length = 10)
    @Pattern(regexp = "[0-9]{10}", message = "O código deve ser inteiro")
    private float debito;

    @Column(name = "idFuncionario", nullable = false, length = 10)
    @Pattern(regexp = "^[0-9]{10}$", message = "Valor de idFuncionario Invalido.")
    private Integer idFuncionario;

    public Integer getIdSalario() {
        return IdSalario;
    }

    public void setIdSalario(Integer idSalario) {
        IdSalario = idSalario;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Integer getId() {
        return IdSalario;
    }

    public void setId(Integer IdSalario) {
        this.IdSalario = IdSalario;
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

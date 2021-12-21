package com.example.ProjetoHotel.entities;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "hospede")
public class Hospede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "idHospede", nullable = false, length = 10)
    @Pattern(regexp = "^[0-9]{10}$", message = "Esse codigo precisa ser um numero inteiro.")
    private Integer idHospede;


    @Column(name = "nome", nullable = false, length = 50)
    @Pattern(regexp = "^[A-Za-z\s]{10,50}$", message = "O nome precisa ter entre 10 a 50 caracteres.")
    private String nome;

    @Column(name = "email", nullable = false, length = 60)
    @Pattern(regexp = "^[A-z0-9_]{1,20}@[A-z]{1,15}\\.([A-z]{1,10}|[A-z]{1,10}\\.[A-z]{1,5})$", message = "Email invalido.")
    private String email;

    @Column(name = "telefone", nullable = false, length = 15)
    @Pattern(regexp = "^\\([0-9]{2}\\)[0-9]{5}-[0-9]{4}$", message = "Numero de telefone invalido.")
    private String telefone;

    @Column(name = "limiteCredito", nullable = false, length = 10)
    @Pattern(regexp = "^[0-9]{1,10}\\.[0-9]{1,4}$", message = "valor inserido para o limite de credito invalido")
    private float limite;

    @Column(name = "idQuarto", nullable = false, length = 10)
    @Pattern(regexp = "^[0-9]{10}$", message = "Valor de IdQuarto Invalido.")
    private Integer idQuarto;

    @Column(name = "ativo")
    private Boolean ativo;



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

package com.example.ProjetoHotel.business;

import com.example.ProjetoHotel.entities.Salario;
import com.example.ProjetoHotel.repositories.SalarioRepository;

import java.util.ArrayList;

public class SalarioBiz {
    private ArrayList<String> erros;
    private SalarioRepository salarioRepository;
    private Salario salario;


    public SalarioBiz(Salario salario, SalarioRepository salarioRepository){
        this.salario = salario;
        this.salarioRepository = salarioRepository;

        erros = new ArrayList<>();
    }

    public Boolean isValid(){
        Boolean resultado;
        resultado = salarioValido(salario.getSalarioBruto());
        resultado = possuiCredito(salario.getCredito()) && resultado;
        resultado = possuiDebito(salario.getDebito()) && resultado;
        resultado = possuiSaldo(salario.getCredito(), salario.getDebito(), salario.getSalarioBruto()) && resultado;
        return resultado;
    }

    public Boolean salarioValido(Float bruto){

        if(bruto >= 1100 && bruto <= 5000){
            return true;
        }else{
            erros.add("O salario deve estar entre 1100 e 5000");
            return false;
        }
    }

    public Boolean possuiCredito(Float creditos){

        if(creditos >= 0){
            return true;
        }else{
            erros.add("O credito não pode ser menor que zero.");
            return false;
        }

    }

    public Boolean possuiDebito(Float debitos){

        if(debitos >= 0){
            return true;
        }else{
            erros.add("O debito não pode ser menor que zero.");
            return false;
        }

    }

    public Boolean possuiSaldo(Float creditos, Float debitos, Float bruto){

        if((creditos+bruto) > debitos){
            return true;
        }else{
            erros.add("Os debitos não devem ser maiores que creditos");
            return false;
        }

    }


    public ArrayList<String> getErros() {
        return erros;
    }

    public void setErros(ArrayList<String> erros) {
        this.erros = erros;
    }
}

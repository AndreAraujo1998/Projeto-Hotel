package com.example.ProjetoHotel.business;

import com.example.ProjetoHotel.repositories.QuartoRepository;

import java.util.List;

public class QuartoBiz {

    /*O tamanho do quarto deve ser maior de 3 mt2
    O preco do dia deve ser acima de 100 e abaixo de 1000
    a quantidade de pessoas deve estar entre 1 e 5
    o andar deve ser maior que zero e abaixo de 20
    o numero do quarto deve estar entre 100 e 1000
    A coluna ativo deve estar true*/


    QuartoRepository quartoRepository;

    private List<String> erros;

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public boolean validTamanhoQrt(Integer tamanhoMetros){
        if (tamanhoMetros > 3){
            return true;
        } else{
            erros.add("O tamanho do quarto deve ser maior que 3m quadrados");
            return false;
        }

    }





}

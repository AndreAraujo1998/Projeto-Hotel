package com.example.ProjetoHotel;

import java.util.ArrayList;
import java.util.List;

public class Mensagem {


    private String mensagem;

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    private List<String> erros;
    public String getMensagem() {
        return mensagem;
    }
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }


    public Mensagem(){
        erros = new ArrayList<>();
    }



}

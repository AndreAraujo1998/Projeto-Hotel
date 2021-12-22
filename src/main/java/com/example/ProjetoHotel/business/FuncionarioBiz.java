package com.example.ProjetoHotel.business;

import com.example.ProjetoHotel.Mensagem;
import com.example.ProjetoHotel.entities.Funcionario;
import com.example.ProjetoHotel.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioBiz {

    FuncionarioRepository funcionarioRepository;
    private Funcionario funcionario;
    private List<String> erros;

    public FuncionarioBiz(Funcionario f, FuncionarioRepository funcionarioRepository){
        erros = new ArrayList<>();
        this.funcionario = f;
        this.funcionarioRepository = funcionarioRepository;
    }

    public Boolean isValid(){
        Boolean resultado;
        resultado = nomeUnico(this.funcionario.getNome());
        resultado =  tamanhoDoNomeValido(this.funcionario.getNome()) && resultado;
        resultado = nomeIniciaMaiuscula(this.funcionario.getNome()) && resultado;

        return resultado;
    }

    public Boolean isValid(Funcionario f){
        this.funcionario = f;
        return isValid();
    }

    // validar para que nao tenha um nome repetido
    public Boolean nomeUnico(String nome){

        Integer quantidade = funcionarioRepository.findByNome(nome).size();
        if (quantidade == 0) {
            return true;
        } else {
            erros.add("O Nome já existe no sistema.");
            return false;
        }
    }

    // tamanho do nome deve ser maiaor que 10
    public Boolean tamanhoDoNomeValido( String nome){
        Integer tamanho = nome.length();
        if (tamanho >= 10 ){
            return true;
        } else {
            erros.add("O tamanho do nome deve ser ter 10 ou mais caracteres");
            return false;
        }
    }

    // o nome deve iniciar com letra maiuscula
    public Boolean nomeIniciaMaiuscula( String nome ){

        Boolean certo = nome.matches("^[A-Z]]");
        if (!certo){
            erros.add("O nome deve iniciar com maiuscula");
        }
        return certo;

    }

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }


}

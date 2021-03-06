package com.example.ProjetoHotel.business;

import com.example.ProjetoHotel.entities.Pedido;
import com.example.ProjetoHotel.entities.Quarto;
import com.example.ProjetoHotel.repositories.PedidoRepository;
import com.example.ProjetoHotel.repositories.QuartoRepository;

import java.util.ArrayList;
import java.util.List;

public class QuartoBiz {

    /*O tamanho do quarto deve ser maior de 3 mt2
    O preco do dia deve ser acima de 100 e abaixo de 1000
    a quantidade de pessoas deve estar entre 1 e 5
    o andar deve ser maior que zero e abaixo de 20
    o numero do quarto deve estar entre 100 e 1000
    A coluna ativo deve estar true*/


    QuartoRepository quartoRepository;
    private Quarto quarto;

    private List<String> erros;
    public List<String> getErros() {
        return erros;
    }
    public void setErros(List<String> erros) {
        this.erros = erros;
    }


    public QuartoBiz(Quarto q, QuartoRepository quartoRepository){
        erros = new ArrayList<>();
        this.quarto = q;
        this.quartoRepository = quartoRepository;
    }

    public Boolean isValid(){
        Boolean resultado;
        resultado = validPrecoDia(this.quarto.getPrecoDia());
        resultado = validTamanhoQrt(this.quarto.getTamanhoMetros())&& resultado;
        resultado = validAtivoQuarto(this.quarto.getAtivo()) && resultado;
        return resultado;
    }

    public Boolean validTamanhoQrt(float tamanhoMetros){
        if (tamanhoMetros > 3){
            return true;
        } else{
            erros.add("O tamanho do quarto deve ser maior que 3m quadrados");
            return false;
        }
    }

    public Boolean validPrecoDia (float precoDia){
        if (precoDia > 100 && precoDia < 1000){
            return true;
        }else{
            erros.add("O valor do quarto deve ser maior que R$100,00 e menor que R$1.000,00 ");
            return false;
        }
    }


    public Boolean validQuantidadePessoas(Integer quantidadePessoas){
        if (quantidadePessoas >0 &&  quantidadePessoas <=5){
            return true;
        }else{
            erros.add("A quantidade de pessoas em cada quarto deve ser maior que 0 e menor que 5");
            return false;
        }
    }

    public Boolean validAndar(Integer andar){
        if (andar >0 && andar <20) {
            return true;
        }else{
            erros.add("O andar do quarto deve ser maior que 0 e menor que 20");
            return false;
        }
    }


    public Boolean validAtivoQuarto(Boolean ativo){
        if (!ativo){
            erros.add("O quarto deve estar ativado");
            return false;
        }else {
            return true;
        }
    }


    public Boolean validNumeroQuarto (Integer numero){
        if (numero >=100 && numero <=1000){
            return true;
        }else{
            erros.add("O n??mero do quarto deve ser menor ou igual a zero e menor ou igual a 1000");
            return false;
        }
    }

}

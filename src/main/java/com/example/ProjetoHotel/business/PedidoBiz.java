package com.example.ProjetoHotel.business;

import com.example.ProjetoHotel.entities.Pedido;
import com.example.ProjetoHotel.entities.Quarto;
import com.example.ProjetoHotel.repositories.FuncionarioRepository;
import com.example.ProjetoHotel.repositories.PedidoRepository;
import com.example.ProjetoHotel.repositories.QuartoRepository;

import java.util.ArrayList;
import java.util.List;

public class PedidoBiz {

    PedidoRepository pedidoRepository;
    QuartoRepository quartoRepository;
    private Pedido pedido;
    private List<String> erros;

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public PedidoBiz(Pedido p, PedidoRepository pedidoRepository){
        erros = new ArrayList<>();
        this.pedido = p;
        this.pedidoRepository = pedidoRepository;
    }

    public Boolean isValid(){
        Boolean resultado;
        resultado = idValido(this.pedido.getIdQuarto());
        resultado = valorValido(this.pedido.getValor()) && resultado;
        resultado = verificaAtivo(this.pedido.getAtivo()) && resultado;
        return resultado;
    }

    public Boolean idValido(Integer idQuarto){
        if (idQuarto > 0){
            return true;
        } else {
            erros.add("O id do quarto deve ser maior que 0");
            return false;
        }
    }

    public Boolean valorValido(Double valor){
        if (valor > 0){
            return true;
        } else{
            erros.add("O valor deve ser maior que 0");
            return false;
        }
    }

    public Boolean verificaAtivo (Boolean ativo){

        if(ativo == false){
            erros.add("O pedido deve estar ativado");
            return false;
        } else{
            return true;
        }
    }

    public Boolean verificaIdQuarto (Integer idQuarto){
        Integer id = quartoRepository.findByIdQuarto(idQuarto).size();

        if(id > 0){
            return true;
        } else {
            erros.add("O id quarto deve ser válido")
            return false;
        }


    }

}

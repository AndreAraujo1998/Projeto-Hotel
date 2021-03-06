package com.example.ProjetoHotel.controller;


import com.example.ProjetoHotel.Mensagem;
import com.example.ProjetoHotel.business.PedidoBiz;
import com.example.ProjetoHotel.entities.Pedido;
import com.example.ProjetoHotel.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping()
    public List<Pedido> listar(){
        List<Pedido> lista = pedidoRepository.findByAtivo(true);
        return lista;
    }

    @GetMapping("/{id}")
    public Pedido buscar(@PathVariable Integer id){

        Pedido pedido = pedidoRepository.findById(id).get();
        return pedido;
    }

    @PostMapping
    public Mensagem incluir (@RequestBody Pedido pedido){
        PedidoBiz pedidoBiz = new PedidoBiz(pedido, pedidoRepository);
        Mensagem msg = new Mensagem();

        if (pedidoBiz.isValid()){
            pedido.setIdQuarto(0);
            pedidoRepository.save(pedido);
            pedidoRepository.flush();
            msg.setMensagem("Pedido incluido com suscesso!");
        } else{
            msg.setErros(pedidoBiz.getErros());
            msg.setMensagem("Erro ao incluir pedido: ");
        }
        return msg;
    }

    @PutMapping  //Mapeia o POST na URL
    public Mensagem alterar(@RequestBody Pedido pedido) {
        pedidoRepository.save(pedido);
        pedidoRepository.flush();
        Mensagem msg = new Mensagem();
        msg.setMensagem("edicao completa");
        return msg;
    }

    @DeleteMapping("{id}")
    public Mensagem deletar(@PathVariable Integer id){
        Pedido excluir = pedidoRepository.findById(id).get();
        excluir.setAtivo(false);
        pedidoRepository.save(excluir);
        pedidoRepository.flush();

        Mensagem msg = new Mensagem();
        msg.setMensagem("Pedido Deletado!");

        return msg;
    }

}

package com.example.ProjetoHotel.controller;


import com.example.ProjetoHotel.Mensagem;
import com.example.ProjetoHotel.entities.Pedido;
import com.example.ProjetoHotel.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pedido")
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
        System.out.println("Incluindo pedido: " + pedido.getIdPedido());
        pedido.setIdPedido(0);
        pedidoRepository.save(pedido);
        pedidoRepository.flush();

        Mensagem msg = new Mensagem();
        msg.setMensagem("inclusao completa");

        return msg;
    }



<<<<<<< HEAD
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
=======
>>>>>>> e770c428cf8b57537503d266722cb7d812379d34











}

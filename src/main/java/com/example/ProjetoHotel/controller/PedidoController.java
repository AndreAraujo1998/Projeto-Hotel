package com.example.ProjetoHotel.controller;


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














}

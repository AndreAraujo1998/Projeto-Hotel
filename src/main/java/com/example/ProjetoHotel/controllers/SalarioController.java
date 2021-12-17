package com.example.ProjetoHotel.controllers;

import com.example.ProjetoHotel.entities.Salario;
import com.example.ProjetoHotel.repositories.SalarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("salario")
public class SalarioController {

    @Autowired
    private SalarioRepository salarioRepository;

    @GetMapping
    public List<Salario> listar(){
        List<Salario> lista = salarioRepository.findAll();
        return lista;
    }

    @GetMapping("/{id}")
    public Salario buscar(@PathVariable int id){
        Salario salario = salarioRepository.findById(id).get();
        return salario;
    }
}

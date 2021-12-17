package com.example.ProjetoHotel.controller;

import com.example.ProjetoHotel.Mensagem;
import com.example.ProjetoHotel.entities.Salario;
import com.example.ProjetoHotel.repositories.SalarioRepository;
import org.hibernate.boot.model.source.spi.PluralAttributeElementSourceAssociation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public Salario incluir (@RequestBody Salario salario){

        System.out.println("Incluindo salario: " + salario.getSalarioBruto());
        salario.setId(0);
        salarioRepository.save(salario);
        salarioRepository.flush();
        return salario;
    }

    @PutMapping
    public Mensagem alterar(@RequestBody Salario salario){
        System.out.println("Alterando o Salario: " + salario.getSalarioBruto());
        salarioRepository.save(salario);
        salarioRepository.flush();

        Mensagem msg = new Mensagem();
        msg.setMensagem("OK!");
        return msg;
    }

}

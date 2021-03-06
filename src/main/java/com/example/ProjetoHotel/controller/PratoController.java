package com.example.ProjetoHotel.controller;

import com.example.ProjetoHotel.Mensagem;
import com.example.ProjetoHotel.business.FuncionarioBiz;
import com.example.ProjetoHotel.business.PratoBiz;
import com.example.ProjetoHotel.entities.Prato;
import com.example.ProjetoHotel.repositories.PratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Prato")
public class PratoController {

    @Autowired
    private PratoRepository pratoRepository;


    @GetMapping()
    public List<Prato> listar(){
        List<Prato> lista = pratoRepository.findByAtivo(true);
        return lista;
    }

    @GetMapping("{id}")
    public Prato buscar(@PathVariable Integer id){
        Prato prato = pratoRepository.findById(id).get();
        return prato;
    }

    /*@PostMapping()
    public Mensagem incluir(@RequestBody Prato prato) {
        PratoBiz pratoBiz = new PratoBiz(prato, pratoRepository);
        Mensagem msg = new Mensagem();

        if (pratoBiz.isValid()) {
            prato.setIdPrato(0);
            pratoRepository.save(prato);
            pratoRepository.flush(); //Comando para gravar a nova aposta efetivamente
            msg.setMensagem("Prato nao incluido com sucesso!");
        } else {
            msg.setErros(pratoBiz.getErros());
            msg.setMensagem("Erro ao incluir o prato : ");
        }
        return msg;
    }*/

    @PutMapping()
    public Mensagem alterar(@RequestBody Prato prato){
        pratoRepository.save(prato);
        pratoRepository.flush();

        Mensagem msg = new Mensagem();
        msg.setMensagem("OK");
        return msg;
    }

    @DeleteMapping()
    public Mensagem excluir(@RequestBody Prato prato){

        Prato excluir = pratoRepository.findById(prato.getIdPrato()).get();
        excluir.setAtivo(false);
        pratoRepository.save(excluir);
        pratoRepository.flush();

        Mensagem msg = new Mensagem();
        msg.setMensagem("OK");
        return msg;
    }

    @DeleteMapping("{id}")
    public Mensagem deletar(@PathVariable Integer id){

        Prato excluir = pratoRepository.findById(id).get();
        excluir.setAtivo(false);
        pratoRepository.save(excluir);
        pratoRepository.flush();

        Mensagem msg = new Mensagem();
        msg.setMensagem("OK2");
        return msg;

    }



}

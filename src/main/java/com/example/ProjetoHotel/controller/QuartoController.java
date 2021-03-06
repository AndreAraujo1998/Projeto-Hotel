package com.example.ProjetoHotel.controller;


import com.example.ProjetoHotel.Mensagem;
import com.example.ProjetoHotel.business.QuartoBiz;
import com.example.ProjetoHotel.entities.Quarto;
import com.example.ProjetoHotel.repositories.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Quarto")
public class QuartoController {

    @Autowired
    private QuartoRepository quartoRepository;

    @GetMapping()
    public List<Quarto> listar(){
        List<Quarto> lista = quartoRepository.findByAtivo(true);
        return lista;
    }

    @GetMapping("{id}")
    public Quarto buscar(@PathVariable Integer id){
        Quarto quarto = quartoRepository.findById(id).get();
        return quarto;
    }

    @PostMapping()
    public Mensagem incluir(@RequestBody Quarto quarto){

        QuartoBiz quartoBiz = new QuartoBiz(quarto, quartoRepository);
        Mensagem msg = new Mensagem();

        if (quartoBiz.isValid()){
            quarto.setIdQuarto(0);
            quartoRepository.save(quarto);
            quartoRepository.flush();
            msg.setMensagem("Quarto Inserido com Sucesso!");
        }else{
            msg.setErros(quartoBiz.getErros());
            msg.setMensagem("Erro ao incluir quarto!");
        }
        return msg;
    }

    @PutMapping()
    public Mensagem alterar(@RequestBody Quarto quarto){

        Mensagem msg = new Mensagem();
        QuartoBiz quartoBiz = new QuartoBiz(quarto, quartoRepository);

        if (quartoBiz.isValid()){
            quarto.setIdQuarto(0);
            quartoRepository.save(quarto);
            quartoRepository.flush();
            msg.setMensagem("Quarto Inserido com Sucesso!");
        }else{
            msg.setErros(quartoBiz.getErros());
            msg.setMensagem("Erro ao incluir quarto!");
        }
        return msg;
    }

    @DeleteMapping()
    public Mensagem excluir(@RequestBody Quarto quarto){

        Quarto excluir = quartoRepository.findById(quarto.getIdQuarto()).get();
        excluir.setAtivo(false);
        quartoRepository.save(excluir);
        quartoRepository.flush();

        Mensagem msg = new Mensagem();
        msg.setMensagem("OK");
        return msg;
    }

    @DeleteMapping("{id}")
    public Mensagem deletar(@PathVariable Integer id){

        Quarto excluir = quartoRepository.findById(id).get();
        excluir.setAtivo(false);
        quartoRepository.save(excluir);
        quartoRepository.flush();

        Mensagem msg = new Mensagem();
        msg.setMensagem("OK");
        return msg;

    }



}

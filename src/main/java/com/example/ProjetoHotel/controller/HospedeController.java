package com.example.ProjetoHotel.controller;


import com.example.ProjetoHotel.entities.Hospede;
import com.example.ProjetoHotel.repositories.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Hospede")
public class HospedeController {

    @Autowired
    private HospedeRepository hospedeRepository;

    @GetMapping()
    public List<Hospede> listar() {
        List<Hospede> lista = hospedeRepository.findByAtivo(true);
        return lista;
    }

    @GetMapping("/{id}") //Chaves significam parametro da URL
    public Hospede buscar(@PathVariable int id) {    //É preciso colocar o path variable para conseguir pegar da url o parametro inserido
        Hospede hospede = hospedeRepository.findById(id).get();
        return hospede;
    }

    @PostMapping //Mapeia o POST na URL
    public Hospede incluir(@RequestBody Hospede hospede) {
        hospede.setId(0);
        hospedeRepository.save(hospede);
        hospedeRepository.flush(); //Comando para gravar a nova aposta efetivamente
        return hospede;
    }

    @PutMapping  //Mapeia o POST na URL
    public Hospede alterar(@RequestBody Hospede hospede) {
        hospedeRepository.save(hospede);
        hospedeRepository.flush(); //Comando para gravar a nova aposta efetivamente
        return hospede;
    }

    @DeleteMapping
    public Hospede deletar(@RequestBody Hospede hospede) {
        Hospede excluir = hospedeRepository.findById(hospede.getId()).get();
        excluir.setAtivo(false);
        hospedeRepository.save(excluir);
        hospedeRepository.flush();
        return excluir;
    }

    @DeleteMapping("{id}")
    public Hospede deletar(@PathVariable Integer id) { //Para funcionar, é preciso colocar id na URL e o JSON pode ir vazio
        Hospede excluir = hospedeRepository.findById(id).get();
        excluir.setAtivo(false);
        hospedeRepository.save(excluir);
        hospedeRepository.flush();
        return excluir;
    }
}

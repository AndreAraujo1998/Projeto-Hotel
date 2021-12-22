package com.example.ProjetoHotel.controller;


import com.example.ProjetoHotel.Mensagem;
import com.example.ProjetoHotel.business.HospedeBiz;
import com.example.ProjetoHotel.entities.Hospede;
import com.example.ProjetoHotel.repositories.HospedeRepository;
import com.example.ProjetoHotel.repositories.QuartoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Hospede")
public class HospedeController {

    @Autowired
    private HospedeRepository hospedeRepository;
    @Autowired
    private QuartoRepository quartoRepository;

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
    public Mensagem incluir(@RequestBody Hospede hospede) {
        HospedeBiz hospedeBiz = new HospedeBiz(hospede, hospedeRepository, quartoRepository);
        Mensagem msg= new Mensagem();

        if (hospedeBiz.isValid()) {
            hospede.setId(0);
            hospedeRepository.save(hospede);
            hospedeRepository.flush(); //Comando para gravar a nova aposta efetivamente
            msg.setMensagem("hospede inserido com sucesso");
        }else{
                msg.setErros(hospedeBiz.getErros());
                msg.setMensagem("Erro ao incluir hospede: ");
        }

        return msg;
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

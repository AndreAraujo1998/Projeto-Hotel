package com.example.ProjetoHotel.controller;


import com.example.ProjetoHotel.Mensagem;
import com.example.ProjetoHotel.business.FuncionarioBiz;
import com.example.ProjetoHotel.entities.Funcionario;
import com.example.ProjetoHotel.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping()
    public List<Funcionario> listar(){
        List<Funcionario> lista = funcionarioRepository.findByAtivo(true);
        return lista;
    }

    //Retorna 1
    @GetMapping("/{id}") //Chaves significam parametro da URL
    public Funcionario buscar(@PathVariable int id) {    //É preciso colocar o path variable para conseguir pegar da url o parametro inserido
        Funcionario aposta = funcionarioRepository.findById(id).get();
        return aposta;
    }

    @PostMapping //Mapeia o POST na URL
    public Mensagem incluir(@RequestBody Funcionario funcionario) {
        FuncionarioBiz funcionarioBiz = new FuncionarioBiz(funcionario, funcionarioRepository);
        Mensagem msg= new Mensagem();

        if (funcionarioBiz.isValid()) {
            funcionario.setIdFuncionario(0);
            funcionarioRepository.save(funcionario);
            funcionarioRepository.flush(); //Comando para gravar a nova aposta efetivamente
            msg.setMensagem("Funcionario incluido com sucesso!");
        } else {
            msg.setErros(funcionarioBiz.getErros());
            msg.setMensagem("Erro ao incluir funciario: ");
        }
        return msg;
    }

    @PutMapping  //Mapeia o POST na URL
    public Funcionario alterar(@RequestBody Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
        funcionarioRepository.flush(); //Comando para gravar a nova aposta efetivamente
        return funcionario;
    }

    @DeleteMapping
    public Funcionario deletar(@RequestBody Funcionario funcionario) {
        Funcionario excluir = funcionarioRepository.findById(funcionario.getIdFuncionario()).get();
        excluir.setAtivo(false);
        funcionarioRepository.save(excluir);
        funcionarioRepository.flush();
        return excluir;
    }

    @DeleteMapping("{id}")
    public Funcionario deletar(@PathVariable Integer id) { //Para funcionar, é preciso colocar id na URL e o JSON pode ir vazio
        Funcionario excluir = funcionarioRepository.findById(id).get();
        excluir.setAtivo(false);
        funcionarioRepository.save(excluir);
        funcionarioRepository.flush();
        return excluir;
    }


}

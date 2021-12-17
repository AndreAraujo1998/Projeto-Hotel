package com.example.ProjetoHotel.repositories;

import com.example.ProjetoHotel.entities.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    List<Funcionario> findByAtivo(Boolean ativo);
}

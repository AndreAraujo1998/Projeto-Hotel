package com.example.ProjetoHotel.repositories;

import com.example.ProjetoHotel.entities.Prato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PratoRepository extends JpaRepository<Prato, Integer> {

    List<Prato> findByAtivo(Boolean ativo);
}

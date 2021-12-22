package com.example.ProjetoHotel.repositories;

import com.example.ProjetoHotel.entities.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto,Integer> {

    List<Quarto> findByAtivo(Boolean ativo);
    List<Quarto> findByIdQuarto (Integer idQuarto);




}

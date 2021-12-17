package com.example.ProjetoHotel.repositories;

import com.example.ProjetoHotel.entities.Prato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Integer> {

    List<Prato> findByAtivo(Boolean ativo);

}

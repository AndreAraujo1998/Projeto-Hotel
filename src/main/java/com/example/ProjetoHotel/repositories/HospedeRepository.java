package com.example.ProjetoHotel.repositories;

import com.example.ProjetoHotel.entities.Hospede;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospedeRepository extends JpaRepository<Hospede, Integer> {

    List<Hospede> findByAtivo(Boolean ativo);
}

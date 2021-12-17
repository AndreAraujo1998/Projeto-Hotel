package com.example.ProjetoHotel.repositories;

import com.example.ProjetoHotel.entities.Prato;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Integer> {

=======

import java.util.List;

public interface PratoRepository extends JpaRepository<Prato, Integer> {

    List<Prato> findByAtivo(Boolean ativo);
>>>>>>> cc8640586577a7b3eaa77b9500e08d1f86de824e
}

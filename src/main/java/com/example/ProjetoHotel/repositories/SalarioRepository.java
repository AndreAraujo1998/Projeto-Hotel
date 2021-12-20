package com.example.ProjetoHotel.repositories;

import com.example.ProjetoHotel.entities.Salario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalarioRepository extends JpaRepository<Salario, Integer> {

}

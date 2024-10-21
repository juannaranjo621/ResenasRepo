package com.company.Resenas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.Resenas.model.Resena;

import java.util.List;

public interface IResenaRepository extends JpaRepository<Resena, Long> {
    Resena findById(long id);
    List<Resena> findByTitulo(String titulo);
}

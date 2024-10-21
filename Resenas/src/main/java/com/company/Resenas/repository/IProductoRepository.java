package com.company.Resenas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.Resenas.model.Producto;
import java.util.List;

public interface IProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByNombre(String nombre);
    List<Producto> findByFabricante(String fabricante);
    Producto findById(long id);
}

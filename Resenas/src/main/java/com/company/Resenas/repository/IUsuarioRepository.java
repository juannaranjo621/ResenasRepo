package com.company.Resenas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.Resenas.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByApellido(String apellido);
    List<Usuario> findByNombre(String nombre);
    List<Usuario> findByNombreAndApellido(String nombre, String apellido);
    Usuario findByTipoDocumentoAndDocumento(String tipoDocumento, String documento);
    Usuario findById(long id);
}

package com.company.Resenas.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.company.Resenas.model.Usuario;

public interface IUsuarioService {
    ResponseEntity<List<Usuario>> listAll();

    ResponseEntity<Usuario> create(Usuario usuario);
    ResponseEntity<?> getById(long id);
    ResponseEntity<Usuario> update(long id, Usuario usuario);
    ResponseEntity<Usuario> delete(long id);
}

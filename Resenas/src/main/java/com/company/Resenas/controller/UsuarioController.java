package com.company.Resenas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.Resenas.model.Usuario;
import com.company.Resenas.service.IUsuarioService;

import lombok.AllArgsConstructor;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@AllArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final IUsuarioService iUsuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        return iUsuarioService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUsuarioById(long id) {
        return iUsuarioService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Usuario> create(Usuario usuario) {
        return iUsuarioService.create(usuario);
    }

    
}

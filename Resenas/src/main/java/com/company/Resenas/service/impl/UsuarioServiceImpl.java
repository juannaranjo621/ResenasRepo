package com.company.Resenas.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.company.Resenas.model.Usuario;
import com.company.Resenas.repository.IUsuarioRepository;
import com.company.Resenas.service.IUsuarioService;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Service
public class UsuarioServiceImpl implements IUsuarioService{
    private final IUsuarioRepository iUsuarioRepository;

    @Override
    public ResponseEntity<List<Usuario>> listAll() {
        try {
            List<Usuario> usuarios = iUsuarioRepository.findAll();
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Usuario> getById(long id) {
        try {
            Usuario usuario = iUsuarioRepository.findById(id);
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @Override
    public ResponseEntity<Usuario> create(Usuario usuario) {
        Usuario usuarioActual = this.iUsuarioRepository
        .findByTipoDocumentoAndDocumento(usuario.getTipoDocumento(), usuario.getDocumento());

        if (usuarioActual != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Usuario usuarioNuevo = Usuario.builder()
        .nombre(usuario.getNombre())
        .apellido(usuario.getApellido())
        .tipoDocumento(usuario.getTipoDocumento())
        .documento(usuario.getDocumento())
        .email(usuario.getEmail())
        .build();

        Usuario usuarioGuardado = iUsuarioRepository.save(usuarioNuevo);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioGuardado);
    }

    @Override
    public ResponseEntity<Usuario> update(long id, Usuario usuario) {
        try {
            Usuario usuarioDatos = iUsuarioRepository.findById(id);

            if (usuarioDatos != null) {
                Usuario usuarioActual = new Usuario();
                usuarioActual.setNombre(usuario.getNombre());
                usuarioActual.setApellido(usuario.getApellido());
                usuarioActual.setTipoDocumento(usuario.getTipoDocumento());
                usuarioActual.setDocumento(usuario.getDocumento());
                usuarioActual.setEmail(usuario.getEmail());

                iUsuarioRepository.save(usuarioActual);

                return ResponseEntity.status(HttpStatus.OK).body(usuarioActual);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<Usuario> delete(long id) {
        try {
            iUsuarioRepository.deleteById(id);

            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}

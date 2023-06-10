package com.example.AtlAcademy.repositories;

import com.example.AtlAcademy.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsers();
    void deleteUser(Long id);

    void createUser(Usuario user);

    Usuario getUserByCredentials(Usuario user);

    boolean existsByEmail(String email);
}

package com.example.AtlAcademy.controllers;

import com.example.AtlAcademy.repositories.UsuarioDao;
import com.example.AtlAcademy.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private EntityManager entityManager;

    @RequestMapping(value = "api/users", method = RequestMethod.GET)
    public List<Usuario> getUsers(@RequestHeader(value="Authorization") String token){
        //if (!validarToken(token)) { return null; }
        return usuarioDao.getUsers();
    }

    @RequestMapping(value = "api/searchUser")
    public Usuario searchUser(){
        Usuario user = new Usuario();
        user.setName("pepe");
        user.setEmail("pepico@hotmail.com");
        return user;
    }

    @RequestMapping(value = "api/editUser")
    public Usuario editUser(){
        Usuario user = new Usuario();
        user.setName("pepe");
        user.setEmail("pepico@hotmail.com");
        return user;
    }

    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id){
       usuarioDao.deleteUser(id);
    }
    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void createUser(@RequestBody Usuario user){

        if(usuarioDao.existsByEmail(user.getEmail())){
            throw new RuntimeException("El email ya está en uso");
        }
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1,1024,1,user.getPassword());
        user.setPassword(hash);

        usuarioDao.createUser(user);
    }


}

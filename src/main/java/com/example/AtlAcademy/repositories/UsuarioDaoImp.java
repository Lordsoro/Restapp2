package com.example.AtlAcademy.repositories;

import com.example.AtlAcademy.models.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Usuario> getUsers() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }
    @Override
    public void deleteUser(Long id){
        Usuario usuario = entityManager.find(Usuario.class ,id);
        entityManager.remove(usuario);
    }
    @Override
    public void createUser(Usuario user){
        entityManager.persist(user);
    }

    @Override
    public Usuario getUserByCredentials(Usuario user) {
        String query = "SELECT u FROM Usuario u WHERE u.email = :email";
        List<Usuario> lista = entityManager.createQuery(query, Usuario.class)
                .setParameter("email", user.getEmail())
                .getResultList();

        if (lista.isEmpty()) {
            return null;
        }

        Usuario loggedUser = lista.get(0);
        String passwordHashed = loggedUser.getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed, user.getPassword())) {
            return loggedUser;
        }
        return null;
    }

    @Override
    public boolean existsByEmail(String email) {
        Query query = entityManager.createQuery("SELECT COUNT(u) FROM Usuario u WHERE u.email = :email");
        query.setParameter("email", email);

        Long count = (Long) query.getSingleResult();
        return count >0;
    }

}

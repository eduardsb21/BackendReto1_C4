/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto1.Reto1_C4.service;

import com.Reto1.Reto1_C4.entity.User;
import com.Reto1.Reto1_C4.repository.UserRepository;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduardsuarez21
 */
@Service
public class UserService implements Serializable {

    @Autowired
    private UserRepository repository;

    public List<User> getUsers() {
        return repository.getUSers();
    }

    public Optional<User> getUSerId(int id) {
        return repository.getUserId(id);
    }

    public User saveUser(User user) {
        return repository.saveUSer(user);
    }

    public boolean existeEmail(String email) {
        return repository.existeEmail(email);
    }

    public User registrar(User user) {
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return repository.saveUSer(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = repository.autenticarUSuario(email, password);
        if (usuario.isEmpty()) {
            return new User(email, password, "NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }
}

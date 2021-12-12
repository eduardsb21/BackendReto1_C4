/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto1.Reto1_C4.repository;

import com.Reto1.Reto1_C4.crudRepository.UserCrudRepository;
import com.Reto1.Reto1_C4.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eduardsuarez21
 */
@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository crudRepository;

    public List<User> getUSers() {
        return (List<User>) crudRepository.findAll();
    }
    public Optional<User> getUserId(int id){
        return crudRepository.findById(id);
    }
    
    public User saveUSer(User user){
        return crudRepository.save(user);
        
    }
    
    public Boolean existeEmail(String email){
        Optional<User> usuario = crudRepository.findByEmail(email);
        return !usuario.isEmpty();
    }
    
    public Optional<User> autenticarUSuario(String email, String password){
        return crudRepository.findByEmailAndPassword(email, password);
    }
}

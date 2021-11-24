/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cuatroa.retouno.retouno.repository;

import com.cuatroa.retouno.retouno.repository.crud.UserCrudRepository;
import com.cuatroa.retouno.retouno.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Esteffany Meneses
 */
@Repository
public class UserRepository {
    
    @Autowired
    private UserCrudRepository repository;

    
    public List<User> getAll() {
        return (List<User>) repository.findAll();
    }

     //Buscar registro por Id
    public Optional<User> getUser(int id){
        return repository.findById(id);
    }
    
    //Buscar por email
   public boolean existeEmail(String email){
       Optional<User> usuario = repository.findByEmail(email);
       return usuario.isPresent();
    }
    
    //Buscar por email y password
    public Optional <User> autenticarUsuario(String email, String password){
        return repository.findByEmailAndPassword(email, password);
    }
    
    public User save(User user) {
        return repository.save(user);
    }

    public void delete(User user) {
       repository.delete(user);
    }
    
}





    

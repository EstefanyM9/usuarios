package com.cuatroa.retouno.retouno.service;

import com.cuatroa.retouno.retouno.model.User;
import com.cuatroa.retouno.retouno.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Esteffany Meneses
 */
@Service
public class UserService {

@Autowired
    private UserRepository repository;
    
    public List<User> getAll(){
        return repository.getAll();
    }
    
    public Optional<User> getUser(int id) {
        return repository.getUser(id);
    }
    
    public boolean existeEmail(String email){
       return repository.existeEmail(email);
    }
    
    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = repository.autenticarUsuario(email, password);

        if (!usuario.isPresent()) {
            return new User(email, password,"NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }

    //Registrar 
 public User registrar(User user) {
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return repository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    
    //Eliminar
    public boolean delete(int id){
        Boolean aBoolean = getUser(id).map(user -> {
           repository.delete(user);
           return true;
        }).orElse(false);
        return aBoolean;
    }     
    
    public User update(User user){
        if(user.getId()!=null){
            Optional<User> resultado = repository.getUser(user.getId());
            if(resultado.isPresent()){
                if(user.getName()!=null){
                    resultado.get().setName(user.getName());
                }
                if(user.getEmail()!=null){
                    resultado.get().setEmail(user.getEmail());
                }
                if(user.getPassword()!=null){
                    resultado.get().setPassword(user.getPassword());
                }
                repository.save(resultado.get());
                return resultado.get();
            }else{
                return user;
            }
        }else{
            return user;
        }
    }
}
    
    
    
      
    
    

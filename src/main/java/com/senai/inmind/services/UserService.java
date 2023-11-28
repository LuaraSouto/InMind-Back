package com.senai.inmind.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.senai.inmind.dtos.UserInputDTO;
import com.senai.inmind.entities.User;
import com.senai.inmind.repositories.AddressRepository;
import com.senai.inmind.repositories.UserRepository;

@Service
@Validated
public class UserService implements UserDetailsService{
        
    @Autowired
    private UserRepository repository;
    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public User create(UserInputDTO dto){
        
        addressRepository.save(dto.getAddress());
        User user = new User(dto);

        User userCreated = repository.save(user);
        return userCreated;

    }

    public User read(Long id){
        return repository.findById(id).get();
    }

    public List<User> list(){
        return (List<User>) repository.findAll();
    }

    @Transactional
    public User update(User user){
        if (repository.existsById(user.getId())) {
            return repository.save(user);
            
        }else{
            return null;
        }
    }

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }


    //Testes de Sistema, solicitado pelo professor Marcos :D
    public Boolean verificarCredenciaisDoUsuario(User user) {

        if (user.getEmail() == null && user.getEmail() == "" && user.getPassword() == "") {
            return false;
        }else{
            return true;
        }
    }

    public Boolean verificarPotenciaSenha(String user) {
        
        if (user.length() >= 8 ) {
            return true;
        }else{
            return false;
        }
        
        
    }

    public Boolean isExistEmail(String emailNovo, String emailRegistrado) {
        if (emailNovo == emailRegistrado) {
            return false;
        }else{
            return true;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if(user != null){
            return org.springframework.security.core.userdetails.User.builder()
                .password(user.getPassword())
                .username(user.getUsername())
            .build();
        }else{
            throw new UsernameNotFoundException("");
        }
    }


}

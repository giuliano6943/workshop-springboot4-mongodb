package com.giuliano.workshopmongo.services;

import com.giuliano.workshopmongo.domain.User;
import com.giuliano.workshopmongo.dto.UserDTO;
import com.giuliano.workshopmongo.repository.UserRepository;
import com.giuliano.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired //Injeção de dependencia
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj){
    return repo.insert(obj);
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }

    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }
}

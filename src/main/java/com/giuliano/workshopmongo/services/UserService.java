package com.giuliano.workshopmongo.services;

import com.giuliano.workshopmongo.domain.User;
import com.giuliano.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired //Injeção de dependencia
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }
}

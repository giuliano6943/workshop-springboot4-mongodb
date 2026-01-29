package com.giuliano.workshopmongo.services;

import com.giuliano.workshopmongo.domain.Post;
import com.giuliano.workshopmongo.domain.User;
import com.giuliano.workshopmongo.dto.UserDTO;
import com.giuliano.workshopmongo.repository.PostRepository;
import com.giuliano.workshopmongo.repository.UserRepository;
import com.giuliano.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> user = repo.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
    public List<Post> findAll() {
        return repo.findAll();
    }

    public List<Post> findBytitle(String text) {
        return repo.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + (24 * 60 * 60 * 1000));
        return repo.fullSearch(text, minDate, maxDate);

    }

}
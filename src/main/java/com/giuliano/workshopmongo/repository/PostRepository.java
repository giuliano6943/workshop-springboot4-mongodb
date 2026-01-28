package com.giuliano.workshopmongo.repository;

import com.giuliano.workshopmongo.domain.Post;
import com.giuliano.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {

    //query methods
    List<Post> findByTitleContainingIgnoreCase(String text);

}

package com.crypterium.teryaev_test.services;

import com.crypterium.teryaev_test.entities.Author;
import com.crypterium.teryaev_test.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public boolean add(Author author){
        if (author.getId() == null) {
            Author savedAuthor = authorRepository.findByName(author.getName());
            if (savedAuthor == null){
                authorRepository.save(author);
                return true;
            }
        }
        return false;
    }
}

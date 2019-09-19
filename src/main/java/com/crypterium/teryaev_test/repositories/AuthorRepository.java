package com.crypterium.teryaev_test.repositories;

import com.crypterium.teryaev_test.entities.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author findByName(String name);
}

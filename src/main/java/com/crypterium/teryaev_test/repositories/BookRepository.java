package com.crypterium.teryaev_test.repositories;

import com.crypterium.teryaev_test.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    Book findByTitle(String title);
}

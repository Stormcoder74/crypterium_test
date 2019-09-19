package com.crypterium.teryaev_test.repositories;

import com.crypterium.teryaev_test.entities.authenticate.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}

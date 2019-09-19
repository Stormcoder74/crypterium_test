package com.crypterium.teryaev_test.repositories;


import com.crypterium.teryaev_test.entities.authenticate.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}

package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository
        extends MongoRepository<user, String> {
    Optional<user> findUserByEmail(String email);

    @Query(value = "{email : ?0}")
    List<user> findByEmail(String email);

    @Query(value = "{name : ?0}")
    List<user> findByName(String name);

    @Query(value="{id : ?0}", delete = true)
    void deleteById (String id);

    @Query(value="{email : ?0}", delete = true)
    void deleteByEmail (String email);

}

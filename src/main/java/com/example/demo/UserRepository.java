package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository
        extends MongoRepository<user, String> {
    Optional<user> findUserByEmail(String email);
}

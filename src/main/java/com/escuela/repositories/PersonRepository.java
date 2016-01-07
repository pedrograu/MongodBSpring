package com.escuela.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.escuela.domain.Person;

public interface PersonRepository extends MongoRepository<Person, String> {

}

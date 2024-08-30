package com.kgisl.sb103.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.kgisl.sb103.entity.Person;

@Repository
public interface PersonRepository extends ListCrudRepository<Person, Long> {

}

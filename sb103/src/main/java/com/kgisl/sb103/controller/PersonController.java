
package com.kgisl.sb103.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.kgisl.sb103.entity.Person;
import com.kgisl.sb103.repository.PersonRepository;


@RestController
@RequestMapping("/persons")  // Base path for all person-related endpoints
public class PersonController {
    @Autowired
    private PersonRepository personRepository;

    // GET all persons
    @GetMapping
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id) {
        Optional<Person> person = personRepository.findById(id);
        return person.orElseThrow(() -> new RuntimeException("Person not found"));
    }

    @PostMapping
    public Person createPerson(@RequestBody Person newPerson) {
        return personRepository.save(newPerson);
    }
    
    
    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person updatedPerson) {
        return personRepository.findById(id)
                .map(person -> {
                    // Update the fields as necessary
                    return personRepository.save(new Person(id, updatedPerson.p_name(), updatedPerson.p_email()));
                })
                .orElseThrow(() -> new RuntimeException("Person not found"));
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
    }
}

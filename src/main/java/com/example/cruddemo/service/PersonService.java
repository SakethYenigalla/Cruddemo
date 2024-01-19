package com.example.cruddemo.service;

import com.example.cruddemo.person.Person;
import com.example.cruddemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    /* public List<Person> getAllPersons() {
         return personRepository.findAll();
     }*/
    public List<Person> getAllPersons() {
        Supplier<List<Person>> findAllLambda = personRepository::findAll;

        return findAllLambda.get();
    }

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

}

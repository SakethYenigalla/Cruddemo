package com.example.cruddemo.controller;

import com.example.cruddemo.exception.InvalidDataException;
import com.example.cruddemo.person.Person;
import com.example.cruddemo.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;


@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
   /* public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }*/
    public List<Person> getAllPersons() {
        Supplier<List<Person>> findAllLambda = () -> personService.getAllPersons();
        return findAllLambda.get();
    }


    @PostMapping
    public Person addPerson(@Valid @RequestBody Person person) {
//        if (person == null) {
//            throw new NullInputException("Input data cannot be null");
//        }

//        validatePerson(person);

        System.out.println(person.toString());
        return personService.addPerson(person);
    }

    private void validatePerson(Person person) {
        if (person.getName() == null || person.getAge() == null) {
            throw new InvalidDataException("Name and age are required fields");
        }
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        try {
            personService.deletePerson(id);
        } catch (InvalidDataException e) {
            throw e;
        }
    }

}

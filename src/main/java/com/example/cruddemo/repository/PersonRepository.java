package com.example.cruddemo.repository;

import com.example.cruddemo.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}


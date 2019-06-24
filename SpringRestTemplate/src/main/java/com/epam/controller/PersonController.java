package com.epam.controller;

import com.epam.model.Person;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    @RequestMapping("/person/{id}")
    public Person person(@PathVariable("id") int personId) {
        for (Person person : getPersons()) {
            if (person.getPersonId() == personId) {
                return person;
            }
        }
        return null;
    }

    @RequestMapping("/persons")
    public List <Person> persons() {
        return getPersons();
    }

    private List <Person> getPersons() {
        List <Person> persons = new ArrayList();
        persons.add(new Person(1, "Ivan", "Ivanov", 35));
        persons.add(new Person(2, "Petr", "Petrov", 40));
        persons.add(new Person(3, "Vadim", "Vadimov", 30));
        return persons;
    }
}

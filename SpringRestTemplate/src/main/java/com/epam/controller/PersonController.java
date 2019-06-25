package com.epam.controller;

import com.epam.dao.PersonDao;
import com.epam.dao.impl.PersonDaoImpl;
import com.epam.model.Person;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private final PersonDao<Person> dao = new PersonDaoImpl();

    @RequestMapping("/person/{id}")
    public Person person(@PathVariable("id") int personId) {
        return dao.getPersonById(personId);
    }

    @RequestMapping("/persons")
    public List <Person> persons() {
        return dao.getListPersons();
    }

}

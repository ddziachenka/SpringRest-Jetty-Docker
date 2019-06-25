package com.epam.dao.impl;

import com.epam.dao.PersonDao;
import com.epam.model.Person;
import com.epam.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonDaoImpl implements PersonDao <Person> {
    private static final Logger LOGGER = Logger.getLogger(PersonDaoImpl.class.getName());
    private static final String GET_ALL_PERSONS = "SELECT person_id, first_name, last_name, age FROM person";
    private static final String GET_PERSON_BY_ID = "SELECT person_id, first_name, last_name, age FROM person WHERE person_id = ?";

    @Override
    public List <Person> getListPersons() {
        List <Person> persons = new ArrayList <>();
        try (Connection connection = DBManager.getConnectionProvider();
             PreparedStatement statement = connection.prepareStatement(GET_ALL_PERSONS)) {
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Person person;
                int personId = result.getInt("person_id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                int age = result.getInt("age");
                person = new Person(personId, firstName, lastName, age);
                persons.add(person);
            }
        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return persons;
    }

    @Override
    public Person getPersonById(int id) {
        Person person = null;
        try (Connection connection = DBManager.getConnectionProvider();
             PreparedStatement statement = connection.prepareStatement(GET_PERSON_BY_ID)) {
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                int personId = result.getInt("person_id");
                String firstName = result.getString("first_name");
                String lastName = result.getString("last_name");
                int age = result.getInt("age");
                person = new Person(personId, firstName, lastName, age);
                return person;
            }
        } catch (SQLException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        }
        return person;
    }
}

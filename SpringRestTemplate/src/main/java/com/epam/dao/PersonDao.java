package com.epam.dao;

import java.util.List;

public interface PersonDao<T> {
    List <T> getListPersons();

    T getPersonById(int id);

}

package ch.example.service;

import javax.ejb.Local;
import java.util.List;

import ch.example.model.Person;
import ch.example.model.Persons;

@Local
public interface SingletonEJBLocal {
    Persons getPersons();

    List<Person> getPerson();

    void addPerson(List<Person> person);
}

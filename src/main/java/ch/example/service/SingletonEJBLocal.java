package ch.example.service;

import javax.ejb.Local;
import java.util.List;

import ch.example.model.Event;
import ch.example.model.Person;
import ch.example.model.Persons;
import ch.example.model.Statistics;

@Local
public interface SingletonEJBLocal {
    Statistics getStatistics();

    void addEvent(Event event);

    Persons getPersons();

    List<Person> getPerson();

    void addPerson(List<Person> person);
}

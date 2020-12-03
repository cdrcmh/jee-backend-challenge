package ch.example.service;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ch.example.model.Event;
import ch.example.model.Person;
import ch.example.model.Persons;
import ch.example.model.Statistics;

@Singleton
@Startup
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class SingletonEJB implements SingletonEJBLocal {

    Persons persons;
    Statistics statistics;

    @PostConstruct
    public void initialize() {
        persons = Persons.builder().build();
        persons.setPerson(new ArrayList<>());
    }

    @Override
    public Persons getPersons() {
        return persons;
    }

    @Override
    public List<Person> getPerson() {
        return persons.getPerson();
    }

    @Override
    public void addPerson(List<Person> person) {
        List<Person> existingPerson = getPerson();
        existingPerson.addAll(person.stream()
                .filter(p -> !existingPerson.contains(p))
                .collect(Collectors.toList()));
    }

}

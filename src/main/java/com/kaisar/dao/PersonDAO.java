package com.kaisar.dao;

import com.kaisar.models.Person;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people = new ArrayList<>();

    {
        people.add(new Person(PEOPLE_COUNT++, "Taisha"));
        people.add(new Person(PEOPLE_COUNT++, "Florinda"));
        people.add(new Person(PEOPLE_COUNT++, "Juan"));
        people.add(new Person(PEOPLE_COUNT++, "Henaro"));
        people.add(new Person(PEOPLE_COUNT++, "Kastaneda"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(PEOPLE_COUNT++);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}

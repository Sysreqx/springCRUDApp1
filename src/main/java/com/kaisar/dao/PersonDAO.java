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
        if (id > PEOPLE_COUNT || id < 0) return null;
        else return people.get(id);
    }

    public void save(Person person) {
        person.setId(PEOPLE_COUNT++);
        people.add(person);
    }
}

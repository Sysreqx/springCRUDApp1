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
        people.add(new Person(PEOPLE_COUNT++, "Taisha", 35, "taisha@gmail.com"));
        people.add(new Person(PEOPLE_COUNT++, "Florinda", 35, "florinda@gmail.com"));
        people.add(new Person(PEOPLE_COUNT++, "Juan",  81, "juan@gmail.com"));
        people.add(new Person(PEOPLE_COUNT++, "Henaro", 93, "henaro@gmail.com"));
        people.add(new Person(PEOPLE_COUNT++, "Kastaneda", 36, "kastaneda@gmail.com"));
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
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}

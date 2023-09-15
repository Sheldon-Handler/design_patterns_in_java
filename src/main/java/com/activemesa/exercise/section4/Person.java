package com.activemesa.exercise.section4;


import java.util.Vector;

class Person {
    public static Vector<Person> personVector = new Vector<>();
    public int id;
    public String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}


class PersonFactory {

    public Person createPerson(String name) {

        // todo
        Person person = new Person(Person.personVector.size(), name);
        Person.personVector.add(person);
        return person;
    }
}



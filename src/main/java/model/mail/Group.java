package model.mail;

import java.util.LinkedList;

public class Group {
    private LinkedList<Person> persons;

    public Group() {
        this.persons = new LinkedList<Person>();
    }

    public void AddPerson(Person p){
        persons.add(p);
    }

    public LinkedList<Person> getListPerson() {
        return persons;
    }
}

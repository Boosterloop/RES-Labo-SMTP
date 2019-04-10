package model.mail;

import java.util.LinkedList;

public class Group {
    private LinkedList<Person> persons;

    Group(LinkedList<Person> persons) {
        this.persons = new LinkedList<>();
        this.persons = persons;
    }

    public LinkedList<Person> getGroup() {
        return persons;
    }
}

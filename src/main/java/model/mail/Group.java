/*
 * Auteurs : Alexandre Monteiro Marques, Alison Savary
 *
 * Cours : RES
 * Laboratoire : SMTP
 *
 * Date : 1 Avril 2019
 *
 */

package model.mail;

import java.util.LinkedList;

public class Group {
    private LinkedList<Person> persons;

    /**
     * Constructeur par défaut
     */
    public Group() {
        this.persons = new LinkedList<Person>();
    }

    /**
     * Ajout un personne au groupe
     * @param p
     */
    public void AddPerson(Person p){
        persons.add(p);
    }

    /**
     * @return la liste de personne du groupe
     */
    public LinkedList<Person> getListPerson() {
        return persons;
    }
}

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
     * Ajoute une personne au groupe
     * @param p Person à ajouter
     */
    public void AddPerson(Person p){
        persons.add(p);
    }

    /**
     * Retourne la liste des personnes du groupe
     * @return Liste des Person du groupe
     */
    public LinkedList<Person> getListPerson() {
        return new LinkedList<Person>(persons);
    }
}

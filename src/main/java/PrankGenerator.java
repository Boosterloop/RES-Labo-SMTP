/*
 * Auteurs : Alexandre Monteiro Marques, Alison Savary
 *
 * Cours : RES
 * Laboratoire : SMTP
 *
 * Date : 1 Avril 2019
 *
 */

package model.prank;

import config.ReadConfig;
import model.mail.Group;
import model.mail.Person;

import java.util.Collections;
import java.util.LinkedList;

public class PrankGenerator {

    private ReadConfig rC;

    public PrankGenerator(ReadConfig rC){
        this.rC = rC;
    }

    /**
     * @return la liste de prank generer
     */
    public LinkedList<Prank> createPranks(){
        final int SIZE_GROUP = 3;
        LinkedList<Prank> pranks = new LinkedList<Prank>();
        LinkedList<String> messages = rC.getMessages();

        int indexMessage = 0;
        int nbGroups = rC.getNbGroups();
        int nbVictims = rC.getNbVictims();

        // verification s'il y a assez de victimes pour le nombre de groupes
        if((nbVictims / nbGroups) < SIZE_GROUP){
            System.out.println("Il n'y a pas assez de victimes pour faire " + nbGroups + " groupes. Un groupe doit contenir" +
                    " au moins " + SIZE_GROUP + " victimes.");
            nbGroups = nbVictims / SIZE_GROUP;
        }

        // Création de la prank avec des groupes generer aléatoirement
        LinkedList<Group> groups = createGroups(rC.getVictims(), nbGroups);
        for(Group group : groups){
            Prank prank = new Prank();

            LinkedList<Person> victims = group.getListPerson();

            // permet de modifier l'ordre des personnes aléatoires
            Collections.shuffle(victims);

            Person sender = victims.get(0);
            victims.remove(0);
            prank.setVictimSender(sender);

            prank.addVictimsRecever(victims);

            prank.setMessage(messages.get(indexMessage));
            indexMessage = ++indexMessage % messages.size();

            pranks.add(prank);
        }

        return pranks;
    }

    /**
     * Créer les groupes aléatoirement
     * @param victims Une liste de personne victimes
     * @param nbGroup Le nombre de group
     * @return Une liste de groupes
     */
    private LinkedList<Group> createGroups(LinkedList<Person> victims, int nbGroup){
        LinkedList<Group> groups = new LinkedList<Group>();

        for(int i = 0; i < nbGroup; ++i)
            groups.add(new Group());

        // permet de parcourir chaque group en ajoutant une personne à chaque fois
        int loop = 0;

        for(Person p : victims){
            groups.get(loop).AddPerson(p);
            loop = ++loop % groups.size();
        }

        return groups;
    }

}

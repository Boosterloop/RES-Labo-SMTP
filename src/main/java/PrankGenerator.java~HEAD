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

    /**
     * Constructeur prenant un lecteur de configuration
     * @param rC ReadConfig, lecteur de configuration
     */
    public PrankGenerator(ReadConfig rC){
        this.rC = rC;
    }

    /**
     * Crée et retourne les Prank
     * @return liste de Prank
     */
    public LinkedList<Prank> createPranks(){
        // Taille minimale d'un groupe
        final int SIZE_GROUP = 3;
        LinkedList<Prank> pranks = new LinkedList<Prank>();
        LinkedList<String> messages = rC.getMessages();

        int indexMessage = 0;
        int nbGroups = rC.getNbGroups();
        int nbVictims = rC.getNbVictims();

        // Vérifie s'il y a assez de victimes pour le nombre de groupes
        if((nbVictims / nbGroups) < SIZE_GROUP){
            System.out.println("Il n'y a pas assez de victimes pour faire " + nbGroups + " groupes. Un groupe doit contenir" +
                    " au moins " + SIZE_GROUP + " victimes.");
            nbGroups = nbVictims / SIZE_GROUP;
        }

        // Création de la Prank avec des groupes générés aléatoirement
        LinkedList<Group> groups = createGroups(rC.getVictims(), nbGroups);

        // Pour chaque groupe
        for(Group group : groups){
            Prank prank = new Prank();

            LinkedList<Person> victims = group.getListPerson();

            // Permet de modifier l'ordre des personnes aléatoirement
            Collections.shuffle(victims);

            // Expéditeur
            Person sender = victims.get(0);
            victims.remove(0);
            prank.setVictimSender(sender);

            // Destinataires
            prank.addVictimsRecever(victims);

            // Message
            prank.setMessage(messages.get(indexMessage));
            indexMessage = ++indexMessage % messages.size();

            pranks.add(prank);
        }

        return pranks;
    }

    /**
     * Crée les groupes aléatoirement
     * @param victims Liste de Person victimes
     * @param nbGroup Nombre de groupes à créer
     * @return Liste de Group
     */
    private LinkedList<Group> createGroups(LinkedList<Person> victims, int nbGroup){
        LinkedList<Group> groups = new LinkedList<Group>();

        // Création des groupes
        for(int i = 0; i < nbGroup; ++i)
            groups.add(new Group());

        // Permet de parcourir chaque groupe en ajoutant une personne à chaque fois
        int loop = 0;

        // Parcourt de la liste des victimes
        for(Person p : victims){
            groups.get(loop).AddPerson(p);
            loop = ++loop % groups.size();
        }
        return groups;
    }

}

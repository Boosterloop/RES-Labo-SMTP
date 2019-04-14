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

    public LinkedList<Prank> createPranks(){
        final int SIZE_GROUP = 3;
        LinkedList<Prank> pranks = new LinkedList<Prank>();
        LinkedList<String> messages = rC.getMessages();

        int indexMessage = 0;
        int nbGroups = rC.getNbGroups();
        int nbVictims = rC.getNbVictims();

        if((nbVictims / nbGroups) < SIZE_GROUP){
            System.out.println("Il n'y a pas asseu de victimes pour faire " + nbGroups + " groupes. Un groupe doit contenir" +
                    "au moins " + SIZE_GROUP + " victimes.");
            nbGroups = nbVictims / SIZE_GROUP;
        }

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

    private LinkedList<Group> createGroups(LinkedList<Person> victims, int nbGroup){
        LinkedList<Group> groups = new LinkedList<Group>();

        for(int i = 0; i < nbGroup; ++i)
            groups.add(new Group());

        int loop = 0;

        for(Person p : victims){
            groups.get(loop).AddPerson(p);
            loop = ++loop % groups.size();
        }

        return groups;
    }

}

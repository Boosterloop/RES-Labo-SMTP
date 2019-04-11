package model.prank;

import model.mail.Group;
import model.mail.Person;

import java.util.LinkedList;

public class PrankGenerator {

    public LinkedList<Group> createGroup(int nbGroup, LinkedList<Person> victims) {
        if ((victims.size() * 3) < nbGroup) {
            System.out.println("Not enough victims");
            return new LinkedList<>();
        }

        LinkedList<Group> result = new LinkedList<>();

        for (int i = 0; i < nbGroup; ++i) {
            result.add(new Group());
        }

        int i = 0;
        for (Person victim:victims) {
            result.get(i % nbGroup).addToGroup(victim);
            ++i;
        }

        return result;
    }

    public LinkedList<Prank> createPrank(LinkedList<Group> groups, String[][] messages, String witnessesToCC) {

        LinkedList<Prank> result = new LinkedList<>();

        for (int i = 0; i < groups.size(); ++i) {
            int indexSender = (int)(Math.random() * (groups.get(i).getGroupSize()));
            Person sender = groups.get(i).getPeople().get(indexSender);
            LinkedList<Person> recipients = groups.get(i).getPeople();
            recipients.remove(indexSender);
            result.add(new Prank(witnessesToCC, sender, recipients, messages[i][0], messages[i][1]));
        }

        return result;
    }

}

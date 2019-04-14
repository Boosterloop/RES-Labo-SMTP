package model.prank;

import java.util.LinkedList;

import model.mail.Mail;
import model.mail.Person;
import util.Utils;

public class Prank {
	
	private Person victimSender;
	private LinkedList<Person> victimsRecever = new LinkedList<Person>();
	private String message;
	
	/**
	 * @return the victimSender
	 */
	public Person getVictimSender() {
		return victimSender;
	}

	/**
	 * @param victimSender the victimSender to set
	 */
	public void setVictimSender(Person victimSender) {
		this.victimSender = victimSender;
	}

	public LinkedList<Person> getVictimsRecever() {
		return new LinkedList<Person>(victimsRecever);
	}

	public void addVictimRecever(Person victim) {
		this.victimsRecever.add(victim);
	}

	public void addVictimsRecever(LinkedList<Person> victims) {
		this.victimsRecever.addAll(victims);
	}


	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public Mail createMail() {
		Mail mail = new Mail();

		mail.setFrom(victimSender.getEmail());

		String[] to = new String[victimsRecever.size()];
		int i = 0;
		for(Person victim : victimsRecever) {
			to[i] = victim.getEmail();
			i++;
		}
		mail.setTo(to);

		String[] messageSubjectAndBody = Utils.getNextLine(message);

		if(!messageSubjectAndBody[0].equals("") && messageSubjectAndBody[0].startsWith("Subject:")) {
			int index = messageSubjectAndBody[0].indexOf(' ');
			mail.setSubject(messageSubjectAndBody[0].substring(index));
			mail.setMessage(messageSubjectAndBody[1]);
		}

		return mail;
	}
}

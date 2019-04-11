package model.prank;

import java.util.LinkedList;

import model.mail.Person;

public class Prank {
	
	private Person victimSender;
	private LinkedList<Person> victimsRecever;
	private String subject;
	private String Message;
	
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
		return victimsRecever;
	}

	public void addVictimRecever(Person victim) {
		this.victimsRecever.add(victim);
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return Message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		Message = message;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}

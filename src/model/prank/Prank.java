package model.prank;

import java.util.LinkedList;

import model.mail.Person;

public class Prank {
	
	private Person victimSender;
	private LinkedList<Person> victimsRecever;
	private LinkedList<Person> victimsCC;
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
	/**
	 * @return the victimsRecever
	 */
	public LinkedList<Person> getVictimsRecever() {
		return victimsRecever;
	}
	/**
	 * @param victimsRecever the victimsRecever to set
	 */
	public void addVictimRecever(Person victim) {
		this.victimsRecever.add(victim);
	}
	/**
	 * @return the victimsCC
	 */
	public LinkedList<Person> getVictimsCC() {
		return victimsCC;
	}
	/**
	 * @param victimsCC the victimsCC to set
	 */
	public void addVictimCC(Person victimCC) {
		this.victimsCC.add(victimCC);
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

}

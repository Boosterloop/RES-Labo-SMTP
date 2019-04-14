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

import java.util.LinkedList;
import model.mail.Mail;
import model.mail.Person;
import util.Utils;

public class Prank {
	
	private Person victimSender;
	private LinkedList<Person> victimsRecever = new LinkedList<Person>();
	private String message;
	
	/**
	 * @return le expeditaire victime
	 */
	public Person getVictimSender() {
		return victimSender;
	}

	/**
	 * @param victimSender Defini le destinataire
	 */
	public void setVictimSender(Person victimSender) {
		this.victimSender = victimSender;
	}

	/**
	 * @return la liste des destinataires
	 */
	public LinkedList<Person> getVictimsRecever() {
		return new LinkedList<Person>(victimsRecever);
	}

	/**
	 * @param victim Ajoute un destinataire
	 */
	public void addVictimRecever(Person victim) {
		this.victimsRecever.add(victim);
	}

	/**
	 * @param victims ajoute une liste destinataire
	 */
	public void addVictimsRecever(LinkedList<Person> victims) {
		this.victimsRecever.addAll(victims);
	}

	/**
	 * @return le message de la prank
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message defini le message de la prank
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Cree le mail de la prank
	 * @return le mail
	 */
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

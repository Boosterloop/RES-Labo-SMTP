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
	 * Retourne l'expéditeur victime
	 * @return Expéditeur victime
	 */
	public Person getVictimSender() {
		return victimSender;
	}

	/**
	 * Définit l'expéditeur
	 * @param victimSender Person expéditeur
	 */
	public void setVictimSender(Person victimSender) {
		this.victimSender = victimSender;
	}

	/**
	 * Retourne la liste des destinataires victimes
	 * @return liste des destinataires
	 */
	public LinkedList<Person> getVictimsRecever() {
		return new LinkedList<Person>(victimsRecever);
	}

	/**
	 * Ajoute un nouveau destinataire
	 * @param victim Person destinataire
	 */
	public void addVictimRecever(Person victim) {
		this.victimsRecever.add(victim);
	}

	/**
	 * Ajoute une liste de destinataires
	 * @param victims liste Person destinataires
	 */
	public void addVictimsRecever(LinkedList<Person> victims) {
		this.victimsRecever.addAll(victims);
	}

	/**
	 * Retourne le message lié à cette Prank
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Définit le message de la Prank
	 * @param message String
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Crée le mail de la Prank
	 * @return objet Mail
	 */
	public Mail createMail() {
		Mail mail = new Mail();

		// Expéditeur
		mail.setFrom(victimSender.getEmail());

		// Destinataires
		String[] to = new String[victimsRecever.size()];
		int i = 0;
		for(Person victim : victimsRecever) {
			to[i] = victim.getEmail();
			i++;
		}
		mail.setTo(to);

		// Sépare le sujet du corps du message
		String[] messageSubjectAndBody = Utils.getNextLine(message);

		if(!messageSubjectAndBody[0].equals("") && messageSubjectAndBody[0].startsWith("Subject:")) {
			int index = messageSubjectAndBody[0].indexOf(' ');
			// Sujet
			mail.setSubject(messageSubjectAndBody[0].substring(index));
			// Corps
			mail.setMessage(messageSubjectAndBody[1]);
		}
		return mail;
	}
}

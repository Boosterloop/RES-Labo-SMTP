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

public class Person {

	private String nom;
	private String prenom;
	private String email;

	/**
	 * Unique constructeur
	 * @param nom
	 * @param prenom
	 * @param email
	 */
	public Person(String nom, String prenom, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
}
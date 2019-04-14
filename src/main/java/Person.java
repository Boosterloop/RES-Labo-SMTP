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
	 * @param nom    : le nom de la personne
	 * @param prenom : le prénom de la personne
	 * @param email  : l'email de la personne
	 */
	public Person(String nom, String prenom, String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	/**
	 * Retourne le nom de la personne
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Retourne le prénom de la personne
	 * @return prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Retourne l'email de la personne
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
}
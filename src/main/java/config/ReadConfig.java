/*
 * Auteurs : Alexandre Monteiro Marques, Alison Savary
 *
 * Cours : RES
 * Laboratoire : SMTP
 *
 * Date : 1 Avril 2019
 *
 */

package config;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import model.mail.Person;

public class ReadConfig {

	private LinkedList<Person> victims = new LinkedList<Person>();
	private String serverIP;
	private int serverPort;
	private LinkedList<String> messages = new LinkedList<String>();
	private int nbGroup;
	private String mailtrapUsername = null;
	private String mailtrapPassword = null;

	/**
	 * Effectue la lecture des fichiers de configuration
	 * @throws IOException en cas de problème de lecture
	 */
	public ReadConfig() throws IOException {
		// Gestion des victimes
		try {
            BufferedReader reader;
			reader = new BufferedReader(new FileReader("./config/victim"));
			String victim = null;
			while(true) {
				victim = reader.readLine();
				if(victim == null) {
				    break;
                }
				victims.add(new Person(null, null, victim));
			}
			reader.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Fichier introuvable");
		}

		// Gestion de config.properties
		Properties properties = new Properties();
		properties.load(new FileInputStream("./config/config.properties"));

		nbGroup = Integer.parseInt(properties.getProperty("numberOfGroups"));
		serverIP = properties.getProperty("smtpServerAddress");
		serverPort = Integer.parseInt(properties.getProperty("smptServerPort"));
		mailtrapUsername = properties.getProperty("mailtrapUsername");
		mailtrapPassword = properties.getProperty("mailtrapPassword");

		// Gestion des messages
        try {
            BufferedReader reader = null;
            reader = new BufferedReader(new FileReader("./config/message"));
            String line = "";
            String message = "";

            while(true) {
                line = reader.readLine();
                if(line == null) {
                    break;
                }
                if(line.equals("#END")) {
                    messages.add(message);
                }
                else {
                    if(line.startsWith("Subject:")) {
                        message = line + "\n";
                    }
                    else {
                        message += line + "\n";
                    }
                }
            }
            reader.close();
        }
        catch(FileNotFoundException e) {
            System.out.println("Fichier introuvable");
        }
	}
	
	/**
	 * Retourne les victimes
	 * @return liste Person victims
	 */
	public LinkedList<Person> getVictims() {
		return victims;
	}

	/**
	 * Retourne le nombre de groupe voulu
	 * @return Nombre de groupes
	 */
	public int getNbGroups() {
		return nbGroup;
	}

	/**
	 * Retourne le nombre de victime
	 * @return Nombre de victimes
	 */
	public int getNbVictims() {
		return victims.size();
	}

	/**
	 * Retourne la liste des messages à utiliser
	 * @return Liste de message
	 */
	public LinkedList<String> getMessages() {
		return messages;
	}

	/**
	 * Retourne l'adresse du serveur
	 * @return Adresse serveur
	 */
	public String getServerIP() {
	    return serverIP;
    }

	/**
	 * Retourne le port du serveur
	 * @return Port du serveur
	 */
	public int getServerPort() {
	    return serverPort;
    }

	/**
	 * Retourne le nom d'utilisateur Mail Trap en base 64
	 * @return Nom d'utilisateur de Mail Trap
	 */
	public String getMailtrapUsername() {
		return mailtrapUsername;
	}

	/**
	 * @return Mot de passe Mail Trap
	 */
	public String getMailtrapPassword() {
		return mailtrapPassword;
	}
}

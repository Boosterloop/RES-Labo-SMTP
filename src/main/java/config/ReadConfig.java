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
		System.out.println(mailtrapUsername);
		mailtrapPassword = properties.getProperty("mailtrapPassword");
		System.out.println(mailtrapPassword);

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
	 * @return Les victimes
	 */
	public LinkedList<Person> getVictims() {
		return victims;
	}

	/**
	 * @return Le nombre de groupe voulu
	 */
	public int getNbGroups() {
		return nbGroup;
	}

	/**
	 * @return Le nombre de victimes
	 */
	public int getNbVictims() {
		return victims.size();
	}

	/**
	 * @return La liste des messages à utiliser
	 */
	public LinkedList<String> getMessages() {
		return messages;
	}

	/**
	 * @return L'adresse IP du serveur
	 */
	public String getServerIP() {
	    return serverIP;
    }

	/**
	 * @return Le port du serveur
	 */
	public int getServerPort() {
	    return serverPort;
    }

	/**
	 * @return Le nom d'utilisateur pour Mail Trap en base 64
	 */
	public String getMailtrapUsername() {
		return mailtrapUsername;
	}

	/**
	 * @return Le mot de passe pour Mail Trap en base 64
	 */
	public String getMailtrapPassword() {
		return mailtrapPassword;
	}
}

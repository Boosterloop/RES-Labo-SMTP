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
	private LinkedList<String> messages;
	private int nbGroup;

	public ReadConfig(String file) throws IOException {
		
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader("./config/victim"));
			String victim = null;
			do {
				victim = reader.readLine();
				/*String[] person = victim.split(" ");

				if(person.length == 3) {
					victims.add(new Person(person[1], person[0], person[2]));
				} */
				victims.add(new Person(null, null, victim));

			} while(victim != null);
			reader.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Fichier introuvable");
		}

		// config.properties
		Properties properties = new Properties();
		properties.load(new FileInputStream("./config/config.properties"));

		nbGroup = Integer.parseInt(properties.getProperty("numberOfGroups"));
		serverIP = properties.getProperty("smtpServerAddress");
		serverPort = Integer.parseInt(properties.getProperty("smptServerPort"));
	}
	
	/**
	 * @return the victims
	 */
	public LinkedList<Person> getVictims() {
		return victims;
	}

	public int getNbGroups() {
		return nbGroup;
	}

	public int getNbVictims() {
		return victims.size();
	}

	public LinkedList<String> getMessages() {
		return messages;
	}
}

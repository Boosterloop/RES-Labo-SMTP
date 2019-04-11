package config;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import model.mail.Person;

public class ReadConfig {

	private LinkedList<Person> victims = new LinkedList<Person>();
	private LinkedList<Person> cc;
	private String serverIP;
	private int serverPort;
	private LinkedList<String> messages;
	private int nbGroup;

	public ReadConfig(String file) throws IOException {
		
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader("./config/listPerson.txt"));
			String victim = null;
			do {
				victim = reader.readLine();
				String[] person = victim.split(" ");

				if(person.length == 3) {
					victims.add(new Person(person[1], person[0], person[2]));
				}

			} while(victim != null);

		}
		catch(FileNotFoundException e) {
			System.out.println("Fichier introuvable");
		}
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

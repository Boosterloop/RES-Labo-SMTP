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

	private LinkedList<Person> victims;

	public ReadConfig(String file) throws IOException {
		
		BufferedReader lecture = null;
		boolean fini = false;
		
		try {
			
			lecture = new BufferedReader(new FileReader("src/listPerson.txt"));

			while(fini != true) {
				String ligne = lecture.readLine();
				if(ligne != null)
					System.out.println(ligne);
				else
					fini = true;
			}
			
		}
		catch(FileNotFoundException fnfe) {
			System.out.println("Fichier introuvable");
		}
	}
	
	/**
	 * @return the victims
	 */
	public LinkedList<Person> getVictims() {
		return victims;
	}	
}

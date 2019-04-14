/*
 * Auteurs : Alexandre Monteiro Marques, Alison Savary
 *
 * Cours : RES
 * Laboratoire : SMTP
 *
 * Date : 1 Avril 2019
 *
 */

import java.io.IOException;
import java.util.LinkedList;

import config.ReadConfig;
import model.mail.Mail;
import model.prank.*;
import smtp.SmtpClient;

public class PrankApplication {

	public static void main(String[] args) throws IOException {
		// Lecture des configurations
		ReadConfig conf = new ReadConfig();
		// Génère les Prank
		PrankGenerator prankGenerator = new PrankGenerator(conf);
		LinkedList<Prank> pranks = prankGenerator.createPranks();

		// Construction du client SMTP
		SmtpClient client = new SmtpClient(conf.getServerIP(), conf.getServerPort());
		client.setMailTrapAuth(conf.getMailtrapUsername(), conf.getMailtrapPassword());

		// Pour chaque Prank
		for(Prank p : pranks) {
			// Création et envoi du mail
			 Mail m = p.createMail();
			 client.sendMail(m);
			 // Si on utilise Mail Trap, attente de 5 secondes après chaque mail
			 if(conf.getServerIP().equals("smtp.mailtrap.io")) {
			 	try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
			 		e.printStackTrace();
				}
			 }
		}
	}
}

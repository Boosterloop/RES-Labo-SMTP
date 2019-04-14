/*
 * Auteurs : Alexandre Monteiro Marques, Alison Savary
 *
 * Cours : RES
 * Laboratoire : SMTP
 *
 * Date : 1 Avril 2019
 *
 */

package smtp;

import model.mail.Mail;

import java.io.IOException;

public interface ISmtpClient {

	/**
	 * Envoie un email
	 * @param mail Mail à envoyer
	 * @throws IOException
	 */
	void sendMail(Mail mail) throws IOException;
}

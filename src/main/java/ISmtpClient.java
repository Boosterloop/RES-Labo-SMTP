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
	 * L'envoi de la prank
	 * @param mail Le mail a envoyé
	 * @throws IOException
	 */
	void sendMail(Mail mail) throws IOException;
}

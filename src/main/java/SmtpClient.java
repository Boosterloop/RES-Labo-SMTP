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

import java.io.*;
import java.net.Socket;

public class SmtpClient implements ISmtpClient{
    private int port;
    private String serverIp;
    private String username = null;
    private String pass = null;

    /**
     * Constructeur : Defini les paramètres du serveur
     * @param ip du serveur
     * @param port du serveur
     */
    public SmtpClient(String ip, int port) {
        serverIp = ip;
        this.port = port;
    }

    /**
     * Permet de definir les configuration du site web MailTrap
     * @param base64Username : nom d'utilisateur
     * @param base64Password : le mot de passe
     */
    public void setMailTrapAuth(String base64Username, String base64Password) {
        username = base64Username;
        pass = base64Password;
    }

    public void sendMail(Mail mail) throws IOException {
        // création du lien entre l'applciation et le serveur
        Socket socket = new Socket(serverIp, port);
        // permettra d'envoyer des messages au serveur
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
        // permettra de lire les informations du serveur
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

        String response = reader.readLine();
        System.out.println(response);

        // envoie au serveur un message de connexion
        writer.print("EHLO localhost\r\n");
        writer.flush();
        response = reader.readLine();
        System.out.println(response);

        while(response.startsWith("250-")) {
            response = reader.readLine();
            System.out.println(response);
        }

        if(serverIp.equals("smtp.mailtrap.io")) {
            // authentification au serveur MailTrap
            writer.print("AUTH LOGIN\r\n");
            writer.flush();
            response = reader.readLine();
            System.out.println(response);
            writer.print(username + "\r\n");
            writer.flush();
            response = reader.readLine();
            System.out.println(response);
            writer.print(pass + "\r\n");
            writer.flush();
            response = reader.readLine();
            System.out.println(response);
        }

        // Création du mail
        // Envoie au serveur l'expédiateur du mail
        writer.print("MAIL FROM: <" + mail.getFrom() + ">\r\n");
        writer.flush();
        response = reader.readLine();
        System.out.println(response);

        // Envoie au serveur les differents destinataires du mail
        for(String s : mail.getTo()) {
            writer.print("RCPT TO: <" + s + ">\r\n");
            writer.flush();
            response = reader.readLine();
            System.out.println(response);
        }

        // Envoie au serveur les differents destinataires en copie du mail
        if(mail.getCc() != null) {
            for(String s : mail.getCc()) {
                writer.print("RCPT TO: <" + s + ">\r\n");
                writer.flush();
                response = reader.readLine();
                System.out.println(response);
            }
        }

        // Envoie au serveur les differents destinataires copie caché du mail
        if(mail.getBcc() != null) {
            for(String s : mail.getBcc()) {
                writer.print("RCPT TO: <" + s + ">\r\n");
                writer.flush();
                response = reader.readLine();
                System.out.println(response);
            }
        }

        // Debut du texte du corps du mail
        writer.print("DATA \r\n");
        writer.flush();
        response = reader.readLine();
        System.out.println(response);

        writer.print("Content-Type: text/plain; charset=\"utf-8\" \r\n");
        writer.flush();

        writer.print("From: " + mail.getFrom() + "\r\n");
        writer.flush();

        writer.print("To: ");
        for(int i = 0; i < mail.getTo().length; i++) {
            if(i > 0) {
                writer.print(", " + mail.getTo()[i]);
            }
            else {
                writer.print(mail.getTo()[i]);
            }
        }
        writer.print("\r\n");
        writer.flush();

        writer.print("Subject: " + mail.getSubject() + "\r\n");
        writer.flush();

        if(mail.getCc() != null) {
            writer.print("Cc:");
            for(int i = 0; i < mail.getCc().length; i++) {
                if(i > 0) {
                    writer.print(", " + mail.getCc()[i]);
                }
                else {
                    writer.print(mail.getCc()[i]);
                }
            }
            writer.print("\r\n");
            writer.flush();
        }
        writer.print("\r\n");
        writer.flush();
        writer.print(mail.getMessage() + "\r\n");
        writer.flush();

        // Fin de l'ecriture du mail
        writer.print(".");
        writer.print("\r\n");
        writer.flush();
        response = reader.readLine();
        System.out.println(response);
        writer.print("QUIT \r\n");
        writer.flush();
        writer.close();
        reader.close();
        socket.close();
    }
}

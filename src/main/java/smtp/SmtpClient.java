package smtp;

import model.mail.Mail;

import java.io.*;
import java.net.Socket;

public class SmtpClient {
    private int port;
    private String serverIp;
    private String username = null;
    private String pass = null;

    public SmtpClient(String ip, int port) {
        serverIp = ip;
        this.port = port;
    }

    public void setMailTrapAuth(String base64Username, String base64Password) {
        username = base64Username;
        pass = base64Password;
    }

    public void sendMail(Mail mail) throws IOException {
        Socket socket = new Socket(serverIp, port);
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

        String response = reader.readLine();
        System.out.println(response);

        writer.print("EHLO localhost\r\n");
        writer.flush();
        response = reader.readLine();
        System.out.println(response);

        while(response.startsWith("250-")) {
            response = reader.readLine();
            System.out.println(response);
        }

        if(serverIp.equals("smtp.mailtrap.io")) {
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

        writer.print("MAIL FROM: <" + mail.getFrom() + ">\r\n");
        writer.flush();
        response = reader.readLine();
        System.out.println(response);

        for(String s : mail.getTo()) {
            writer.print("RCPT TO: <" + s + ">\r\n");
            writer.flush();
            response = reader.readLine();
            System.out.println(response);
        }

        if(mail.getCc() != null) {
            for(String s : mail.getCc()) {
                writer.print("RCPT TO: <" + s + ">\r\n");
                writer.flush();
                response = reader.readLine();
                System.out.println(response);
            }
        }

        if(mail.getBcc() != null) {
            for(String s : mail.getBcc()) {
                writer.print("RCPT TO: <" + s + ">\r\n");
                writer.flush();
                response = reader.readLine();
                System.out.println(response);
            }
        }

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

        // Fin
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

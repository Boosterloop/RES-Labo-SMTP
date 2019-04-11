package smtp;

import model.mail.Mail;

import java.io.*;
import java.net.Socket;

public class SmtpClient {
    private int port;
    private String serverIp;
    private PrintWriter out;
    private BufferedReader in;

    public SmtpClient(String ip, int port) {
        serverIp = ip;
        this.port = port;
    }

    public void sendMail(Mail mail) throws IOException {
        Socket socket = new Socket(serverIp, port);
        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

        String response = in.readLine();
        System.out.println(response);

        out.println("EHLO localhost");
        response = in.readLine();
        System.out.println(response);

        while(response.startsWith("250-")) {
            response = in.readLine();
            System.out.println(response);
        }

        out.println("MAIL FROM: " + mail.getFrom());
        response = in.readLine();
        System.out.println(response);

        for(String s : mail.getTo()) {
            out.println("RCPT TO: " + s);
            response = in.readLine();
            System.out.println(response);
        }

        if(mail.getCc() != null) {
            for(String s : mail.getCc()) {
                out.println("RCPT TO: " + s);
                response = in.readLine();
                System.out.println(response);
            }
        }

        if(mail.getBcc() != null) {
            for(String s : mail.getBcc()) {
                out.println("RCPT TO: " + s);
                response = in.readLine();
                System.out.println(response);
            }
        }

        out.println("DATA");
        response = in.readLine();
        System.out.println(response);

        out.println("Content-Type: text/plain; charset=\"utf-8\"");

        out.println("From: " + mail.getFrom());

        out.print("To: ");
        for(int i = 0; i < mail.getTo().length; i++) {
            if(i > 0) {
                out.print(", " + mail.getTo()[i]);
            }
            else {
                out.print(mail.getTo()[i]);
            }
        }
        out.println();

        out.println("Subject: " + mail.getSubject());

        if(mail.getCc() != null) {
            out.print("Cc:");
            for(int i = 0; i < mail.getCc().length; i++) {
                if(i > 0) {
                    out.print(", " + mail.getCc()[i]);
                }
                else {
                    out.print(mail.getCc()[i]);
                }
            }
            out.println();
        }

        out.println();
        out.println(mail.getMessage());

        // Fin
        out.println(".");
        out.flush();
        response = in.readLine();
        System.out.println(response);
        out.println("QUIT");
        out.flush();
        out.close();
        in.close();
        socket.close();
    }
}

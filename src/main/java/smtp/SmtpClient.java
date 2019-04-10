package smtp;

import model.mail.Mail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SmtpClient {
    private int port;
    private String ip;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public SmtpClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    private void connect() {
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendMail(Mail mail) {
        try {
            out.println("");
            String resp = in.readLine();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void disconnect() {
        // Send QUIT
        try {
            in.close();
            out.close();
            clientSocket.close();
        }
        catch (IOException e) {

        }
    }
}

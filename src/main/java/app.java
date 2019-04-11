import java.io.IOException;

import config.ReadConfig;
import model.mail.Mail;
import smtp.SmtpClient;

public class app {

	public static void main(String[] args) throws IOException {
		//new ReadConfig("..\\listPerson.txt");

		SmtpClient client = new SmtpClient("192.168.99.100", 2525);
		Mail m = new Mail();
		m.setFrom("testFrom@test.ch");
		String[] to = {"testTo1@test.ch", "testTo@test.ch"};
		m.setTo(to);
		m.setSubject("Test SMTP client");
		m.setMessage("Salut,\n " +
					"ceci est un test du client SMTP.\n" +
					"A bientôt !");

		client.sendMail(m);

	}
}

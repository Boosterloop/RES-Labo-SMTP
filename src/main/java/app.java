import java.io.IOException;

import config.ReadConfig;
import model.mail.Mail;
import smtp.SmtpClient;

public class app {

	public static void main(String[] args) throws IOException {
		ReadConfig conf = new ReadConfig("..\\listPerson.txt");
		System.out.println(conf.getMessages());
		System.out.println(conf.getNbGroups());
		System.out.println(conf.getNbVictims());
		System.out.println(conf.getServerIP());


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

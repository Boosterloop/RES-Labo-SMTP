import java.io.IOException;
import java.util.LinkedList;

import config.ReadConfig;
import model.mail.Mail;
import model.prank.*;
import smtp.SmtpClient;

public class PrankApplication {

	public static void main(String[] args) throws IOException {
		ReadConfig conf = new ReadConfig();

		PrankGenerator prankGenerator = new PrankGenerator(conf);

		LinkedList<Prank> pranks = prankGenerator.createPranks();

		SmtpClient client = new SmtpClient(conf.getServerIP(), conf.getServerPort());
		client.setMailTrapAuth(conf.getMailtrapUsername(), conf.getMailtrapPassword());

		for(Prank p : pranks) {
			 Mail m = p.createMail();
			 client.sendMail(m);
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

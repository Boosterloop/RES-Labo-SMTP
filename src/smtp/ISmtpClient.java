package smtp;

import model.mail.Message;

public interface ISmtpClient {

	public void sendMail(Message message);
}

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailSent {

	public static void main(String[] args) throws EmailException {
	
		
		System.out.println("======Test Started======");
		
	Email email = new SimpleEmail();
	email.setHostName("smtp.gmail.com");
	email.setSmtpPort(465);
	email.setAuthenticator(new DefaultAuthenticator("zak.minds@gmail.com", "Minds@123"));
	email.setSSLOnConnect(true);
	email.setFrom("zak.minds@gmail.com");
	email.setSubject("TestMail");
	email.setMsg("This is a test mail ... :-)");
	email.addTo("zak.minds@gmail.com");
	email.send();
	
	System.out.println("======Email Sent");
	
	
}
}
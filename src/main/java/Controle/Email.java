package Controle;

import java.util.logging.Level;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;

public class Email {
	public Email() {

	}

	// Envia um email com o assunto e a mensagem recebida
	public static void enviarEmail(String emailUsuario, String assunto, String mensagem) {
		try{
			SimpleEmail email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthentication("grupomidas2015@gmail.com", "grupomidas12");
			email.setSSLOnConnect(true);
			email.setFrom("grupomidas2015@gmail.com");
			email.setSubject(assunto);
			email.setMsg(mensagem);
			email.addTo(emailUsuario);
			email.send();
		} catch (EmailException ex)
		{
			//Logger.getLogger(Email.class.getName().log(Level.SEVERE,null,ex));
		}
	}
}

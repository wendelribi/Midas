package Controle;

import java.util.logging.Level;
import org.apache.commons.mail.*;
import org.apache.log4j.Logger;

public class Email {
	public Email() {

	}

	// Envia um email com o assunto e a mensagem recebida
	public static boolean enviarEmail(String emailUsuario, String assunto, String mensagem) {
		try {
			SimpleEmail email = new SimpleEmail();
			email.setSocketTimeout(10000);
			email.setSocketConnectionTimeout(10000);
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthentication("grupomidas2015@gmail.com", "grupomidas12");
			email.setSSLOnConnect(true);
			email.setFrom("grupomidas2015@gmail.com");
			email.setSubject(assunto);
			email.setMsg(mensagem);
			email.addTo(emailUsuario);
			email.send();
		} catch (EmailException ex) {
			return false;
		}
		return true;
	}
}

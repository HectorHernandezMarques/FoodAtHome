package ContactService;



import java.security.Security;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.catalina.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//Anotaciones
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.sun.mail.smtp.SMTPTransport;





@RestController
public class MailController {
	
	@Autowired
	
	private JavaMailSender javaMailSender;
	
	
	//Email y contraseña para usuario
	//private final String usrname = "practicadad.2018@gmail.com"; //Ejemplo
	//@Value ("${password}") private String password; //La contraseña la indico en el application.properties
	
	//Get mapping para indicar la url donde se envia el correo
	@GetMapping(value = "/mail/{email}")
	public ResponseEntity <Boolean> send (@PathVariable String email){
		
		
		try {
			Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
			final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
			
			
			Properties prop_pass  = System.getProperties(); //Coge la contraseña de app properties
			prop_pass.setProperty("mail.smtps.host", "smtp.gmail.com");
			prop_pass.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
			prop_pass.setProperty("mail.smtp.socketFactory.fallback", "false");
			prop_pass.setProperty("mail.smtp.port", "465"); //Puerto 465 porque utilizamos SSL
			prop_pass.setProperty("mail.smtp.socketFactory.port", "465");
			prop_pass.setProperty("mail.smtps.auth", "true");
			
			Session new_session = Session.getInstance(prop_pass, null); //Crea la sesion con la contraseña que hemos cogido de las properties
			//Creamos mensaje de tipo MIME, formato para mensajes en SMTP
			final MimeMessage message = new MimeMessage(new_session);
			
			message.setFrom(new InternetAddress("username"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email, false)); //Indicamos donde se dirige el email (TO)
			message.setSubject("Pedido FoodAtHome");
			message.setText("Su pedido se ha realizado con exito " + email + " en aproximadamente 30 minutos podra recibirlo en la direccion que nos ha facilitado, que lo disfrute");
			
//			@REQUESTMAPPING("/HOLA")
//		    PUBLIC VOID TEST() {
//		    		SYSTEM.OUT.PRINTLN("HOLA");
//		    		GSON GSON = NEW GSON();
//		    		STRING JSONINSTRING = GSON.TOJSON(NEW EMAIL("MANOLO", "PACO", "HOLA QUE TAL TODO"));
//		    		SYSTEM.OUT.PRINTLN(JSONINSTRING);
//		    }
			
			
			//Uso de SMTP para enviar el correo
//			SMTPTransport sending = (SMTPTransport) new_session.getTransport("smtps");
//			sending.connect(System.getProperties(Host),spring.mail.username, "password");
//			sending.sendMessage(message,  message.getAllRecipients());
//			sending.close();
			
			javaMailSender.send(message);
			
		}
		
		catch  (MessagingException exception) {
			System.out.println(exception);
		}	
		
		return new ResponseEntity <Boolean> (true, HttpStatus.OK);
	}

}

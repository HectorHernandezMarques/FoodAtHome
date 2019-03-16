package ContactService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//Anotaciones
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired

    private JavaMailSender javaMailSender;

    //Email y contraseña para usuario
    private final String usrname = "practicadad.2018@gmail.com"; //Ejemplo
    //@Value ("${password}") private String password; //La contraseña la indico en el application.properties

    //Get mapping para indicar la url donde se envia el correo
    @PostMapping(value = "/mail/")
    public ResponseEntity<Boolean> sendMail(@RequestBody Email mail) {

        String name = mail.getName();
        String email = mail.getEmail();

        System.out.println("Datos correctamente recibidos!");
        System.out.println("Nombre: " + name + "  Email: " + email);

        try {
//			Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
//			final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

//			Properties prop_pass  = System.getProperties(); //Coge la contraseña de app properties

//			Session new_session = Session.getInstance(prop_pass, null); //Crea la sesion con la contraseña que hemos cogido de las properties
            //Creamos mensaje de tipo MIME, formato para mensajes en SMTP
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper;

            helper = new MimeMessageHelper(message, true);

//			message.setFrom(new InternetAddress(usrname));
            helper.setTo(email); //Indicamos donde se dirige el email (TO)
            helper.setSubject("Pedido FoodAtHome");
            helper.setText("Su cuenta se ha realizado con exito para el correo " + email + " podra acceder a nuestros servicios de compra con el usuario y contraseña que haya metido, que lo disfrute " + name + "!");

            //Uso de SMTP para enviar el correo
            //	SMTPTransport sending = (SMTPTransport) new_session.getTransport("smtps");
//			sending.connect(System.getProperties(Host),spring.mail.username, "password");
            //		sending.sendMessage(message,  message.getAllRecipients());
//			sending.close();

            javaMailSender.send(message);

        } catch (MessagingException exception) {
            System.out.println(exception);
        }

        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

}

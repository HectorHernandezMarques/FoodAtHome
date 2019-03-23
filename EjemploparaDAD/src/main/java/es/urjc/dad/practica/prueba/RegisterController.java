package es.urjc.dad.practica.prueba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import es.urjc.dad.practica.prueba.Repositories.UsersRepository;
import es.urjc.dad.practica.prueba.Entity.User;
import es.urjc.dad.practica.prueba.Entity.Email;

@Controller
public class RegisterController {

    @Autowired
    UsersRepository userRepositorio;

    @PostMapping(value = "/registroCliente")
    public String registroCliente(@RequestParam String name, @RequestParam String email, @RequestParam String password) {
        if ((userRepositorio.findByEmail(email) == null) && (!name.equals("")) && (!email.equals(""))) {
            System.out.println(email);

            User nuevoUsuario = new User(name, email, password, "ROLE_USER");
            Email nuevoEmail = new Email(name, email);
            userRepositorio.save(nuevoUsuario);

            String url = "http://hectorh-internal-service:8070/mail/";
            RestTemplate rest = new RestTemplate();
            rest.postForLocation(url, nuevoEmail);
            System.out.println("Datos enviados!");

            return ("parteprivada");
        } else {
            return ("web_html");
        }
    }
}
package es.urjc.dad.practica.prueba;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;


import es.urjc.dad.practica.prueba.Repositories.UsersRepository;
import es.urjc.dad.practica.prueba.Entity.User;


@Controller
public class RegisterController {
	
	@Autowired
	UsersRepository userRepositorio;
	

	@GetMapping(value="/registroCliente")
	public String registrCliente( String name, String email,String password) {
		
		if(userRepositorio.findByName(name) == null) {
			
			User nuevoUsuario = new User (name, email, password, "ROLE_USER");
			userRepositorio.save(nuevoUsuario);
			
			
		    String url= "http://localhost:8070/mail/" + email;
		    RestTemplate rest = new RestTemplate();
		    rest.getForObject(url, String.class);
		    System.out.println("Datos enviados!");
			
			return ("parteprivada");
			
		} else {
			
			return("registro");
			
		}
	
	}


}
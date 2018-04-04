/*package es.urjc.dad.practica.prueba;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import es.urjc.dad.practica.prueba.Entity.User;
import es.urjc.dad.practica.prueba.Repositories.UsersRepository;

@Controller
public class RegisterController {

		@Autowired
		UsersRepository usrRep;
		
		@PostMapping(value = "/nuevoUsuario")
		public String registroUsuario(@RequestParam String email, @RequestParam String password) {
			
			if (usrRep.findByEmail(email) == null) { //Si el usuario no existe vamos a hacer el registro
				
				//Creacion y guardado de usuarios en BD
				User nuevoUsuario = new User (email, password, "ROLE_USER");
				usrRep.save(nuevoUsuario);
				
				//Conexion con APIRest del servicio interno, enviara un email con la confirmación del registro
				String url = "http://localhost:8060/mail" + email;
				RestTemplate restTemp = new RestTemplate();
				restTemp.getForObject(url, String.class);
				
				
				return "registro";
			}
			else {
				
				return "registro";
			}
			
			
			
		}
}*/

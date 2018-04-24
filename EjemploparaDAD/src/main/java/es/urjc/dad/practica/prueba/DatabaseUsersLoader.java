package es.urjc.dad.practica.prueba;

import javax.annotation.PostConstruct;

//import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.urjc.dad.practica.prueba.Entity.User;
import es.urjc.dad.practica.prueba.Repositories.UsersRepository;

@Component
	public class DatabaseUsersLoader {
 @Autowired
 	private UsersRepository userRepository;
 @PostConstruct
 	private void initDatabase() {

	 userRepository.save(new User("MiguelAngel","miguel5691@gmail","vino","ROLE_USER"));
	 userRepository.save(new User("Dani","miguel5692@gmail.com","vino","ROLE_USER"));
	 userRepository.save(new User("User","miguel5693@gmail","vino","ROLE_USER"));
	 userRepository.save(new User("Admin","miguel5694@gmail","patatas","ROLE_USER","ROLE_ADMIN"));
	 userRepository.save(new User("Romo","miguel5695@gmail","patatas","ROLE_USER","ROLE_ADMIN"));
	 }
}


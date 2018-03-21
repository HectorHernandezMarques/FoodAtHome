package es.urjc.dad.practica.prueba;

import javax.annotation.PostConstruct;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
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

	 userRepository.save(new User("MiguelAngel","vino","ROLE_USER"));
	 userRepository.save(new User("Dani","vino","ROLE_USER"));
	 userRepository.save(new User("User","vino","ROLE_USER"));
	 userRepository.save(new User("Admin","patatas","ROLE_USER","ROLE_ADMIN"));
	 userRepository.save(new User("Romo","patatas","ROLE_USER","ROLE_ADMIN"));
	 }
}


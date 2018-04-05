package es.urjc.dad.practica.prueba.Repositories;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

import es.urjc.dad.practica.prueba.Entity.User;

public interface UsersRepository extends CrudRepository<User, Long> {

    User findByName(String name);
	//User findByEmail(String email);
    
    @Cacheable
	User findByEmail(String email);

}

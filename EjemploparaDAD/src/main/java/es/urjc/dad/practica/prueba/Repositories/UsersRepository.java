package es.urjc.dad.practica.prueba.Repositories;


import org.springframework.data.repository.CrudRepository;

import es.urjc.dad.practica.prueba.Entity.User;

public interface UsersRepository extends CrudRepository<User, Long> {

    User findByName(String name);

}

package es.urjc.dad.practica.prueba.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.dad.practica.prueba.Entity.Comidas;

public interface ComidasRepository extends JpaRepository<Comidas, Long> {

}

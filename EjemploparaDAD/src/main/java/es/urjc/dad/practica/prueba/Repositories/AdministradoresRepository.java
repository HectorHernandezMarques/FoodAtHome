package es.urjc.dad.practica.prueba.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.dad.practica.prueba.Entity.Administradores;

public interface AdministradoresRepository extends JpaRepository<Administradores, Long> {

}

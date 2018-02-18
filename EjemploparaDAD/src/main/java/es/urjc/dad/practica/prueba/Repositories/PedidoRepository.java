package es.urjc.dad.practica.prueba.Repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.dad.practica.prueba.Entity.Pedidos;

public interface PedidoRepository extends JpaRepository<Pedidos, Long> {

	List<Pedidos> findByprecio(int precio);
	

}

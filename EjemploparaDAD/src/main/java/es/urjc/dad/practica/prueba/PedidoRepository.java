package es.urjc.dad.practica.prueba;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedidos, Long> {

	List<Pedidos> findByprecio(int precio);
	List<Pedidos> findByproductos(String productos);

}

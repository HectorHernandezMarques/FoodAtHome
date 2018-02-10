package es.urjc.dad.practica.prueba;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepository extends JpaRepository<Productos, Long> {

	List<Productos> findByprecio(int precio);
	List<Productos> findBynombre(String nombre);

}

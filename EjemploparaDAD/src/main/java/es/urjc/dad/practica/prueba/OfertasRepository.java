package es.urjc.dad.practica.prueba;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfertasRepository extends JpaRepository<Ofertas, Long> {

	List<Ofertas> findByprecio(int precio);
	List<Ofertas> findBymenuOferta(String menuOferta);

}

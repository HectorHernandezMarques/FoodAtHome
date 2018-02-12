package es.urjc.dad.practica.prueba;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;

//import java.util.List;

@Entity
public class Pedidos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String productos;
	private int precio;
	
//	
//	@OneToMany
//	private List<Productos> productos1;
	
	protected Pedidos() {

	}

	
	public Pedidos(String productos, int precio) {
		super();
		this.productos = productos;
		this.precio = precio;
			}
	
	
	public String getproductos() {
		return productos;
	}

	public void setproductos(String productos) {
		this.productos = productos;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}




	@Override
	public String toString() {
		return "Anuncio productos=" + productos + ", precio=" + precio + "€";
	}

}

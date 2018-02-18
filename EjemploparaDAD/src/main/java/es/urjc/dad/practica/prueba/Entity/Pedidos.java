package es.urjc.dad.practica.prueba.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

//import java.util.List;

@Entity
public class Pedidos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	

	private String comentario;
	private int precio;
	
	@OneToOne
	private Comidas Comidas;
	@OneToOne
	private Bebidas Bebidas;
	@OneToOne
	private Ofertas Ofertas;
	@OneToOne
	private Administradores Administradores;
	
//	
//	@OneToMany
//	private List<Productos> productos1;
	
	protected Pedidos() {

	}

	
	public Pedidos(String comida,String bebida,String oferta,String administrador,String comentario, int precio) {
		super();
		
		
		this.comentario=comentario;
		this.precio = precio;
			}


	


	public String getComentario() {
		return comentario;
	}


	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}




	@Override
	public String toString() {
		return "Comidad y bebida=" + Comidas + Bebidas+ ", precio=" + precio + "€";
	}

}

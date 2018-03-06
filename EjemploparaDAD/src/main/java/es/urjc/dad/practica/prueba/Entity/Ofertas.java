package es.urjc.dad.practica.prueba.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Ofertas {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private int precio;
	private String comentario;
	
	@OneToMany 
	private List<Comidas> comidas = new ArrayList<>();
	
	@OneToMany 
	private List <Bebidas> bebidas = new ArrayList<>();
	

	protected Ofertas() {

	}

	public Ofertas(String nombre,String Comidas,String Bebidas, int precio, String comentario) {
		super();
		
		this.nombre = nombre;
		this.precio = precio;
		this.comentario = comentario;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Comidas> getComidas() {
		return comidas;
	}

	public void setComidas(List<Comidas> comidas) {
		this.comidas = comidas;
	}

	public List<Bebidas> getBebidas() {
		return bebidas;
	}

	public void setBebidas(List<Bebidas> bebidas) {
		this.bebidas = bebidas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

//	@Override
//	public String toString() {
//		return "Anuncio [nombre=" + nombre + ", precio=" + precio + "€ comida y bebida=" + Comidas + Bebidas +"comentario=" + comentario + "]";
//	}

}






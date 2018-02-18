package es.urjc.dad.practica.prueba.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bebidas {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	public String tipo;
	private String nombre;
	private int precio;
	private String comentario;
	
//	@ManyToOne
//	private Ofertas oferta;
	
	public Bebidas(String tipo,String nombre, int precio, String comentario) {
		super();
		this.tipo=tipo;
		this.nombre = nombre;
		this.precio = precio;
		this.comentario = comentario;
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

	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	protected Bebidas() {

	}



}

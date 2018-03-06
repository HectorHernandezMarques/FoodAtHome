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
	
	public Boolean tipo;
	private String nombre;
	private int precio;
	private String comentario;
	
	
	public Bebidas(Boolean tipo,String nombre, int precio, String comentario) {
		super();
		this.tipo=tipo;
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

	public Boolean getTipo() {
		
		return tipo;
	}


	public void setTipo(Boolean tipo) {
		this.tipo = tipo;
	}


	protected Bebidas() {

	}



}

package es.urjc.dad.practica.prueba;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class Ofertas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String menuOferta;
	private int precio;
	private String comentario;
	
	@OneToMany
	private List<Productos> productos;
	
	protected Ofertas() {

	}

	
	public Ofertas(String menuOferta, int precio, String comentario) {
		super();
		this.menuOferta = menuOferta;
		this.precio = precio;
		this.comentario = comentario;
	}
	
	
	public String getMenuOferta() {
		return menuOferta;
	}

	public void setMenuOferta(String menuOferta) {
		this.menuOferta = menuOferta;
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

	@Override
	public String toString() {
		return "Anuncio [menuOferta=" + menuOferta + ", precio=" + precio + "€ , comentario=" + comentario + "]";
	}

}

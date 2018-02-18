package es.urjc.dad.practica.prueba.Entity;



import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.List;

@Entity
public class Pedidos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	

	private String comentario;
	private int precio;
	
	@OneToMany
	private List<Comidas> comidas = new ArrayList<>();
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

	
	public Pedidos(String comida,Bebidas bebida,String oferta,String administrador,String comentario, int precio) {
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


	public Bebidas getBebidas() {
		return Bebidas;
	}


	public void setBebidas(Bebidas bebidas) {
		Bebidas = bebidas;
	}


	public Ofertas getOfertas() {
		return Ofertas;
	}


	public void setOfertas(Ofertas ofertas) {
		Ofertas = ofertas;
	}


	public Administradores getAdministradores() {
		return Administradores;
	}


	public void setAdministradores(Administradores administradores) {
		Administradores = administradores;
	}


	@Override
	public String toString() {
		return "Comidad y bebida=" + comidas + Bebidas+ ", precio=" + precio + "€";
	}

}

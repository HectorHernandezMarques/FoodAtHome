package es.urjc.dad.practica.prueba;

//import java.util.ArrayList;
//import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.dad.practica.prueba.Entity.Comidas;
import es.urjc.dad.practica.prueba.Entity.Bebidas;
import es.urjc.dad.practica.prueba.Entity.Pedidos;
import es.urjc.dad.practica.prueba.Repositories.PedidoRepository;
import es.urjc.dad.practica.prueba.Repositories.ComidasRepository;
import es.urjc.dad.practica.prueba.Repositories.BebidasRepository;

@Controller
public class Controlador  {
	
	@Autowired
	private ComidasRepository comidas;
	
	@Autowired
	private PedidoRepository pedidos;
	
	@Autowired
	private BebidasRepository bebidas;
	
	private String infoCompartida;
	private String tipo;
	
	
	@PostConstruct
	public void init(){
		
	    comidas.save(new Comidas("Hamburguesa",2,""));
		comidas.save(new Comidas("Pizza",6,""));
		comidas.save(new Comidas("Patatas",3,""));
		bebidas.save(new Bebidas("","Agua",1,""));
		bebidas.save(new Bebidas("","Ceveza", 2,""));
		

	}
	
	

	@GetMapping(value = "/pedidoActual")
	public String procesarFormulario(@RequestParam String info,int precio, HttpSession sesion) {
		
		
		sesion.setAttribute("infoPedido", info);
		sesion.setAttribute("infoPrecio", precio);
		infoCompartida = info;

		return "pedidoinfo";
	}
	
	@GetMapping("/mostrarPedido")
	public String mostrarDatos(Model model, HttpSession sesion) {

		String infoPedido = (String) sesion.getAttribute("infoPedido");
		int infoPrecio = (int) sesion.getAttribute("infoPrecio");

		model.addAttribute("infoPedido", infoPedido);
		model.addAttribute("infoPrecio",infoPrecio);
		
		

		return "prueba2";
	}
	
	@RequestMapping ("/main")
	public String contWeb (Model model){		
		
		
		return "web_html";
	}
	@RequestMapping("/admin")
	public String Admin (Model model, @RequestParam String name){
		
		model.addAttribute("name",name);
		
		return "Admin";
	

	}
	
	@GetMapping("/")
	public String tablon(Model model) {

		model.addAttribute("comidas", comidas);

		return "prueba";
	}
	
	
	
	@GetMapping("/main/Contacto")
	public String Contacto(Model model) {
		
		//model.addAttribute();
		
		return "Contacto";
	}
	
	
	

	@GetMapping("/main/Productos")
	public String Productos(Model model) {
		
		model.addAttribute("comidas", comidas.findAll());
		model.addAttribute("bebidas",bebidas.findAll());
		
		return "Productos";	
	}
	

	@GetMapping("/main/oferta1")
	public String Oferta1(Model model) {
		
		
		
		return "oferta1";
		
		
	}
	
	@GetMapping("/main/oferta2")
	public String Oferta2(Model model) {
		
		
		
		return "oferta2";
		
		
	}
	
	@GetMapping("/main/oferta3")
	public String Oferta3(Model model) {
		
		
		
		return "oferta3";
		
		
	}
	
	
	@GetMapping("/anadproduc")
	public String anadProduc(Model model){
		
		model.addAttribute("comidas", comidas.findAll());
		model.addAttribute("bebidas", bebidas.findAll());
		
		
		
		return "AnadirProductos";
	}
	
	
	
	@PostMapping("/anadproduc/nuevo")
	public String nuevoProducto(Model model, Comidas comidanew, Bebidas bebidanew) {
		
		if (tipo=="comida") {

		comidas.save(comidanew);
		}
		else{
		bebidas.save(bebidanew);}

		return "prueba";
	}
	
	@GetMapping("/pedir")
	public String nuevoPedido(Model model) {

		model.addAttribute("pedidos",pedidos.findAll());

		return "Productos";
	}
	
	@PostMapping("/pedido")
	public String nuevoPedido(Model model, Pedidos pedidonew) {

		pedidos.save(pedidonew);

		return "pedidoinfo2";
	}
		
}

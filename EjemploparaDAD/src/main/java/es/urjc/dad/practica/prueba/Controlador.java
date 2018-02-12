package es.urjc.dad.practica.prueba;

//import java.util.ArrayList;
//import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador  {
	
	@Autowired
	private ProductosRepository productos;
	
	@Autowired
	private OfertasRepository ofertas;
	
	@PostConstruct
	public void init(){
		
		productos.save(new Productos("Hamburguesa",2,""));
		productos.save(new Productos("Pizza",6,""));
		productos.save(new Productos("Patatas",3,""));
		productos.save(new Productos("Agua",1,""));
		
		
		ofertas.save(new Ofertas("Menu Hamburguesa",5, ""));
		ofertas.save(new Ofertas("Menu Pizza", 6, "")); 
		ofertas.save(new Ofertas("Menu Doble", 5, ""));
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

		model.addAttribute("productos", productos);

		return "prueba";
	}
	
	
	
	@GetMapping("/main/Contacto")
	public String Contacto(Model model) {
		
		//model.addAttribute();
		
		return "Contacto";
	}
	
	
	

	@GetMapping("/main/Productos")
	public String Productos(Model model) {
		
		model.addAttribute("productos", productos.findAll());
		
		return "Productos";	
	}
	

	@GetMapping("/main/oferta1")
	public String Ofertas(Model model) {
		
		model.addAttribute("ofertas", ofertas.findAll());
		
		return "oferta1";
		
		
	}
	
	
	@GetMapping("/anadproduc")
	public String anadProduc(Model model){
		
		model.addAttribute("productos", productos.findAll());
		
		
		return "AnadirProductos";
	}
	
	
	
	@PostMapping("/anadproduc/nuevo")
	public String nuevoProducto(Model model, Productos productonew) {

		productos.save(productonew);

		return "prueba";
	}
	
		
}

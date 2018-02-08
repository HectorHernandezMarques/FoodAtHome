package es.urjc.dad.practica.prueba;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador  {
	
	private List<Productos> productos = new ArrayList<>();
	public Controlador(){
		
		productos.add(new Productos("Hamburguesa",2,""));
		productos.add(new Productos("Pizza",6,""));
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
	
	@GetMapping("/anadproduc")
	public String anadProduc(Model model){
		
		
		model.addAttribute("productos", productos);
		
		
		return "AnadirProductos";
	}
	
	@PostMapping("/anadproduc/nuevo")
	public String nuevoProducto(Model model, Productos productonew) {

		productos.add(productonew);

		return "prueba";

	}
	
}

package es.urjc.dad.practica.prueba;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador  {
	@RequestMapping ("/main")
	
	public String contWeb (Model model){		
		
		
		return "web_html";
	}
	@RequestMapping("/admin")
	public String Admin (Model model, @RequestParam String name){
		
		model.addAttribute("name",name);
		
		
		
		return "Admin";
	

	}
}

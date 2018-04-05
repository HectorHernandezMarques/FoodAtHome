package es.urjc.dad.practica.prueba;

//import java.util.ArrayList;
//import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import es.urjc.dad.practica.prueba.Entity.Bebidas;
import es.urjc.dad.practica.prueba.Entity.Comidas;
import es.urjc.dad.practica.prueba.Entity.Ofertas;
import es.urjc.dad.practica.prueba.Entity.Pedidos;
import es.urjc.dad.practica.prueba.Entity.User;
import es.urjc.dad.practica.prueba.Repositories.BebidasRepository;
import es.urjc.dad.practica.prueba.Repositories.ComidasRepository;
import es.urjc.dad.practica.prueba.Repositories.OfertasRepository;
import es.urjc.dad.practica.prueba.Repositories.PedidoRepository;
import es.urjc.dad.practica.prueba.Repositories.UsersRepository;

@Controller
public class Controlador  {
	
	@Autowired
	private ComidasRepository comidaR;
	 
	@Autowired
	private PedidoRepository pedidoR;
	
	@Autowired
	private BebidasRepository bebidaR;
	
	@Autowired
	private OfertasRepository ofertaR;
	
	@Autowired
	private UsersRepository usrRep;
	
	private String infoCompartida;
	
	long CountPedido = 1;
	int precioPed=0;
	
	
	@PostConstruct
	public void init(){
		
	    
//		comidaR.save(new Comidas("Pizza",6,""));
//		comidaR.save(new Comidas("Patatas",3,""));
//		bebidaR.save(new Bebidas(true,"Agua",1,""));
//		bebidaR.save(new Bebidas(true,"Ceveza", 2,""));
//		ofertaR.save(new Ofertas("Oferta1",2,""));
//		ofertaR.save(new Ofertas("Oferta2",2,""));
//		ofertaR.save(new Ofertas("Oferta3",2,""));
		
		Comidas HAM =new Comidas("Hamburguesa",2,"");
		Comidas PIZ =new Comidas("Pizza",3,"");
		Comidas PAT =new Comidas("Patatas",3,"");
		Comidas CAL = new Comidas("Callos", 10,"");
		Comidas LEC = new Comidas("Lechuga", 3,"");
		Bebidas AGU =new Bebidas(true,"Agua",1,"");
		Bebidas CER =new Bebidas(true,"Cerveza",2,"");
		Bebidas VIN =new Bebidas(true,"Vino",2,"");
		Bebidas COL =new Bebidas(true,"Refresco Cola",2,"");
		Bebidas GAS =new Bebidas(true,"Gaseosa",1,"");
		Ofertas OF1 =new Ofertas("Oferta1",2,"");
		Ofertas OF2 =new Ofertas("Oferta2",7,"");
		Ofertas OF3 =new Ofertas("Oferta3",9,"");
		Pedidos pedido = new Pedidos("Pedido1",1);
		
		comidaR.save(HAM);
		comidaR.save(PIZ);
		comidaR.save(PAT);
		comidaR.save(CAL);
		comidaR.save(LEC);
		bebidaR.save(AGU);
		bebidaR.save(CER);
		bebidaR.save(VIN);
		bebidaR.save(COL);
		bebidaR.save(GAS);
		
		
		
		OF1.getComidas().add(HAM);
		OF2.getBebidas().add(AGU);
		OF2.getComidas().add(PIZ);
//		OF2.getComidas().add(HAM);
		OF3.getComidas().add(PAT);
	
		pedido.getComidas().add(CAL);
		pedido.getComidas().add(LEC);
		
		System.out.println(CAL.getNombre());

		pedidoR.save(pedido);
		ofertaR.save(OF1);
		ofertaR.save(OF2);
		ofertaR.save(OF3);
		
		
		
	

	}
	
	
	
	@RequestMapping ("/main")
	public String contWeb (Model model, HttpServletRequest request) {

		 model.addAttribute("admin", request.isUserInRole("ADMIN"));
		
		return "web_html";
	}
	@GetMapping("/admin")
	public String Admin (Model model){ 
		
		
		return "Admin";
	

	}
	
	
	@GetMapping("/loginerror")
	public String LoginError (){
		
		
		
		return "loginerror";
	

	}
	
	@GetMapping("/login")
	public String Login (Model model){ 
		
		
		
		return "parteprivada";
	

	}
	
	
	
	
	@GetMapping("/")
	public String tablon(Model model) {

		model.addAttribute("comidas", comidaR);

		return "prueba";
	}
	
	
	
	@GetMapping("/main/Contacto")
	public String Contacto(Model model) {
		
		//model.addAttribute();
		
		return "Contacto";
	}
	
	
	

	@GetMapping("/main/Productos")
	public String Productos(Model model) {
		
		model.addAttribute("comidas", comidaR.findAll());
		model.addAttribute("bebidas",bebidaR.findAll());
		
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
	
	@GetMapping("/Pedidos")
	public String Pedidos(Model model)
	{
		model.addAttribute("pedidos", pedidoR.findAll());
		
		return "Pedido";
	}
	
	@GetMapping("/anadoferta")
	public String anadOferta(Model model){
		
		return "mantenimiento";
	}
	
	@GetMapping("/anadproduc")
	public String anadProduc(Model model){
		
		model.addAttribute("comidas", comidaR.findAll());
		model.addAttribute("bebidas", bebidaR.findAll());
		
		
		
		return "AnadirProductos";
	}
	
	
	
	@PostMapping("/anadproduc/nuevo")
	public String nuevoProducto(Model model, Comidas comidanew, Bebidas bebidanew) {
		
		System.out.println(bebidanew.getTipo());
		System.out.println(bebidanew.getNombre());
		System.out.println(comidanew.getNombre());
		
		if (bebidanew.getTipo()) {
			
 
		bebidaR.save(bebidanew);
		}
		else
		{
		comidaR.save(comidanew);
		}

		return "prueba";
		
	}
	
//	@GetMapping("/pedir")
//	public String nuevoPedido(Model model) {
//		model.addAttribute("pedidos",pedidoR.findAll());
//
//		return "Productos";
//	}
	
	@PostMapping("/pedido")
	public String nuevoPedido(Pedidos pedidonew, Model model ) {		

		pedidoR.save(pedidonew);

		return "pedidoinfo2";
	}
	@PostMapping("/main/Productos/pedirComida")
	public String nuevoPedidoComida(Model model,Comidas c,HttpServletRequest request){		
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");

		Pedidos pedidonew = pedidoR.getOne(CountPedido);
		c=comidaR.getOne(c.getId());
		pedidonew.getComidas().add(c);
		pedidonew.setComentario("Pedido "+ CountPedido);
		precioPed= precioPed + (c.getPrecio());
		pedidoR.save(pedidonew);
		
		
		
		return "web_html";
	}

	
	
	@PostMapping("/main/Productos/pedirBebida")
	
	public String nuevoPedidoBebida(Model model, Bebidas b) {
		
		
		Pedidos pedidobeb = pedidoR.getOne(CountPedido);
		b=bebidaR.getOne(b.getId());
		pedidobeb.getBebidas().add(b);
		pedidobeb.setComentario("Pedido "+ CountPedido);
		precioPed= precioPed + (b.getPrecio());
		pedidoR.save(pedidobeb);
		
		
		return "web_html";
	}
	
	@GetMapping("/main/Ofertas/pedirOferta")
	
	public String nuevoPedidoOferta(Model model, Ofertas o) {

		Pedidos pedidoof = pedidoR.getOne(CountPedido);
		o=ofertaR.getOne(o.getId());
		pedidoof.getOfertas().add(o);
		pedidoof.setComentario("Pedido "+ CountPedido);
		precioPed= precioPed + (o.getPrecio());
		pedidoR.save(pedidoof);
		
		
		
		
		return "web_html";
	}
		
	@GetMapping("/main/Pedido/comprarPedido")
	public String comprarPedido(Model model,Pedidos pedidonew){
		pedidonew.setPrecio(precioPed);
		pedidoR.save(pedidonew);
		precioPed=0;
		CountPedido++;
		pedidonew = pedidoR.getOne(CountPedido);
		pedidonew.setId(CountPedido);
		pedidoR.save(pedidonew);
		return "web_html";
	}
	
	
	
	
	
}

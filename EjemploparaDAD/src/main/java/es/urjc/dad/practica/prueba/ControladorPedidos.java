//package es.urjc.dad.practica.prueba;
//
//	import java.util.List;
//
//	import javax.annotation.PostConstruct;
//
//	import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//	import org.springframework.web.bind.annotation.RestController;
//	import org.springframework.http.ResponseEntity;
//
//
//import es.urjc.dad.practica.prueba.Entity.Bebidas;
//import es.urjc.dad.practica.prueba.Entity.Comidas;
//import es.urjc.dad.practica.prueba.Entity.Ofertas;
//import es.urjc.dad.practica.prueba.Entity.Pedidos;
//import es.urjc.dad.practica.prueba.Repositories.BebidasRepository;
//import es.urjc.dad.practica.prueba.Repositories.ComidasRepository;
//import es.urjc.dad.practica.prueba.Repositories.OfertasRepository;
//import es.urjc.dad.practica.prueba.Repositories.PedidoRepository;
//
//
//	@RestController
//	public class ControladorPedidos {
//
//		@Autowired
//		private PedidoRepository pedidoR;
//		
//		@Autowired
//		private ComidasRepository comidaR;
//		
//		@Autowired
//		private BebidasRepository bebidaR;
//		
//		@Autowired
//		private OfertasRepository ofertaR;
//
//		@PostConstruct
//		public void init() {
// 
//			Comidas c1 = new Comidas("Callos", 10,"");
//			Comidas c2 = new Comidas("Lechuga", 3,"");
//			
//			comidaR.save(c1);
//			comidaR.save(c2);
//			
//			 Pedidos pedido = new Pedidos("Pedido1",1);
//			
//			pedido.getComidas().add(c1);
//			pedido.getComidas().add(c2);
//			
//			System.out.println(c1.getNombre());
// 
//			pedidoR.save(pedido);
//		}
//
//		@RequestMapping("/pedi")
//		public List<Pedidos> getPedidos() throws Exception {
//			return pedidoR.findAll();
//		}
//		
//		@GetMapping("/main/Productos")
//		public String Productos(Model model) {
//			
//			model.addAttribute("comidas", comidaR.findAll());
//			model.addAttribute("bebidas",bebidaR.findAll());
//			
//			return "Productos";	
//		}
//		
//		@PostMapping("/main/Productos/pedirComida")
//		public String nuevoPedidoComida(Model model,Comidas c, Pedidos pedidonew) {
//			
//			
//			c=comidaR.getOne(c.getId());
//			pedidonew.getComidas().add(c);
//			pedidoR.save(pedidonew);
//			
//			return "prueba2";
//		}
//
//		
//		
//		@PostMapping("/main/Productos/pedirBebida")
//		
//		public String nuevoPedidoBebida(Model model, Bebidas b, Pedidos pedidonew) {
//			
//			b=bebidaR.getOne(b.getId());
//			pedidonew.getBebidas().add(b);
//			pedidoR.save(pedidonew);
//			
//			return "prueba2";
//		}
//		
//		@PostMapping("/pedirOferta")
//		
//		public String nuevoPedidoOferta(Model model, Ofertas o, Pedidos pedidonew) {
//			
//			o=ofertaR.getOne(o.getId());
//			pedidonew.getOfertas().add(o);
//			pedidoR.save(pedidonew);
//			
//			return "PEDIDO";
//		}
		
//		@GetMapping("/pedir")
//		public String nuevoPedido(Model model,Bebidas b, Comidas c, Pedidos pedidonew){
//			
//			pedidonew.getComidas().add(c);
//			pedidonew.getBebidas().add(b);
//			pedidoR.save(pedidonew);
//			
//			
//			return"PEDIDO";
//		}
		
		
//	}



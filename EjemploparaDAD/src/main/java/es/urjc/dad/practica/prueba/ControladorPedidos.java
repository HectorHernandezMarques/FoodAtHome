package es.urjc.dad.practica.prueba;

	import java.util.List;

	import javax.annotation.PostConstruct;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import es.urjc.dad.practica.prueba.Entity.Comidas;
import es.urjc.dad.practica.prueba.Entity.Pedidos;
import es.urjc.dad.practica.prueba.Repositories.ComidasRepository;
import es.urjc.dad.practica.prueba.Repositories.PedidoRepository;


	@RestController
	public class ControladorPedidos {

		@Autowired
		private PedidoRepository pedidoR;
		
		@Autowired
		private ComidasRepository comida;

//		@PostConstruct
//		public void init() {
//
////			Comidas p1 = new Comidas("Torres", 10,"");
////			Comidas p2 = new Comidas("Iniesta", 10,"");
////			
////			comida.save(p1);
////			comida.save(p2);
//			
//			 Pedidos pedido = new Pedidos("Selección","","Agua","Agua","Pedido1", 1);
//			
//			pedido.getComidas().add(p1);
//			pedido.getComidas().add(p2);
//
//			pedidoR.save(pedido);
//		}

		@RequestMapping("/pedi")
		public List<Pedidos> getPedidos() throws Exception {
			return pedidoR.findAll();
		}
	}



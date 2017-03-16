package ttps.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ttps.clases.Cartelera;
import ttps.interfacesDAO.CarteleraDAO;

@Component
public class CarteleraService {
	
	CarteleraDAO carteleraDAO;
	
	@Autowired
	public CarteleraService(CarteleraDAO carteleraDAO){
		this.carteleraDAO = carteleraDAO;
	}
	
	public Cartelera guardar(Cartelera c){
		return carteleraDAO.guardar(c);
	}
}

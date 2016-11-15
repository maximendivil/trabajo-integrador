

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Cartelera;
import clases.Publicacion;
import clases.Publicador;
import clasesDAO.FactoryDAO;
import interfacesDAO.AlumnoDAO;

/**
 * Servlet implementation class Prueba
 */
@WebServlet("/Prueba")
public class Prueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prueba() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		//Creamoas las carteleras
		Cartelera c = new Cartelera("Ingresantes", new Date());
		Cartelera c1 = new Cartelera("Primer año", new Date());
		Cartelera c2 = new Cartelera("Segundos año", new Date());
		Cartelera c3 = new Cartelera("Tercer año", new Date());
		Cartelera c4 = new Cartelera("Cuarto año", new Date());
		Cartelera c5 = new Cartelera("Quinto año", new Date());
		Cartelera c6 = new Cartelera("Institucional", new Date());
		Cartelera c7 = new Cartelera("Eventos", new Date());
		Cartelera c8 = new Cartelera("Ofrecimientos laborales", new Date());
		
		guardarCarteleras(c,c1,c2,c3,c4,c5,c6,c7,c8);
		
		c.setNombre("Cartelera de ingresantes");
		c6.setNombre("Cartelera institucional");
		c8.setNombre("Propuestas laborales");
		
		modificarCarteleras(c,c6,c8);
		
		borrarCarteleras(c1,c2,c3,c4,c5,c7);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void guardarCarteleras(Cartelera c, Cartelera c1, Cartelera c2, Cartelera c3, Cartelera c4, Cartelera c5, Cartelera c6, Cartelera c7, Cartelera c8){
				try {
					c = FactoryDAO.getCarteleraDAO().guardar(c);
					c1 = FactoryDAO.getCarteleraDAO().guardar(c1);
					c2 = FactoryDAO.getCarteleraDAO().guardar(c2);
					c3 = FactoryDAO.getCarteleraDAO().guardar(c3);
					c4 = FactoryDAO.getCarteleraDAO().guardar(c4);
					c5 = FactoryDAO.getCarteleraDAO().guardar(c5);
					c6 = FactoryDAO.getCarteleraDAO().guardar(c6);
					c7 = FactoryDAO.getCarteleraDAO().guardar(c7);
					c8 = FactoryDAO.getCarteleraDAO().guardar(c8);
					System.out.println("Se guardaron las carteleras correctamente");
				}
				catch (Exception e){
					System.out.println(e.getMessage());
				}
	}
	
	private void modificarCarteleras(Cartelera c, Cartelera c1, Cartelera c2){
		try {
			c = FactoryDAO.getCarteleraDAO().modificar(c);
			c1 = FactoryDAO.getCarteleraDAO().modificar(c1);
			c2 = FactoryDAO.getCarteleraDAO().modificar(c2);
			System.out.println("Se modificaron las carteleras correctamente");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private void borrarCarteleras(Cartelera c, Cartelera c1, Cartelera c2, Cartelera c3, Cartelera c4, Cartelera c5 ){
		try {
			c = FactoryDAO.getCarteleraDAO().eliminar(c.getId());
			c1 = FactoryDAO.getCarteleraDAO().eliminar(c1.getId());
			c2 = FactoryDAO.getCarteleraDAO().eliminar(c2.getId());
			c3 = FactoryDAO.getCarteleraDAO().eliminar(c3.getId());
			c4 = FactoryDAO.getCarteleraDAO().eliminar(c4.getId());
			c5 = FactoryDAO.getCarteleraDAO().eliminar(c5.getId());
			System.out.println("Se eliminaron las carteleras correctamente");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

}

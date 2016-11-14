

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
		//Creo una cartelera de ejemplo
		Cartelera c = new Cartelera("Primer año", new Date());
		//Persona que publica
		Publicador pr = new Publicador("Publicador","Cheteado",new Date(),123456,"pubicador@cheto",2,"publicador_cheto","soyrecheto123");
		//Publicacion de prueba
		Publicacion p = new Publicacion("Publicacion de prueba", "Es una descripción cualquiera", "Imagen", new Date(),pr);
		p.setCartelera(c);
		//Persistimos
		try {
			c = FactoryDAO.getCarteleraDAO().guardar(c);
			pr = FactoryDAO.getPublicadorDAO().guardar(pr);
			p = FactoryDAO.getPublicacionDAO().guardar(p);
			System.out.println("Se guardó correctamente");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}



import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clases.Administrador;
import clases.Alumno;
import clases.Cartelera;
import clases.Profesor;
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
		
		//Creamoas las carteleras
		Cartelera c = new Cartelera("Ingresantes", new Date());
		Cartelera c1 = new Cartelera("Primer año", new Date());
		Cartelera c2 = new Cartelera("Segundo año", new Date());
		Cartelera c3 = new Cartelera("Tercer año", new Date());
		Cartelera c4 = new Cartelera("Cuarto año", new Date());
		Cartelera c5 = new Cartelera("Quinto año", new Date());
		Cartelera c6 = new Cartelera("Institucional", new Date());
		Cartelera c7 = new Cartelera("Eventos", new Date());
		Cartelera c8 = new Cartelera("Ofrecimientos laborales", new Date());
		
		guardarCarteleras(c,c1,c2,c3,c4,c5,c6,c7,c8);
		
		/*c.setNombre("Cartelera de ingresantes");
		c6.setNombre("Cartelera institucional");
		c8.setNombre("Propuestas laborales");
		
		modificarCarteleras(c,c6,c8);
		
		borrarCarteleras(c1,c2,c3,c4,c5,c7);*/
		
		//Creamos usuarios
		Administrador a1 = new Administrador("Facundo","Oreja",new Date(),30123456,"admin1@admin.com",1,"admin1","admin");
		Administrador a2 = new Administrador("Viejo","Cuida Bici",new Date(),30123456,"admin2@admin.com",1,"admin2","admin");
		Administrador a3 = new Administrador("John","Maddog",new Date(),30123456,"admin3@admin.com",1,"admin3","admin");
		
		guardarAdministradores(a1,a2,a3);
		
		//Creamos alumnos
		Alumno al1= new Alumno("Maximiliano","Mendivil",new Date(2,1,1993),36734753,"maximendivil22@gmail.com",3,"maximendivil","123","11982/1");
		Alumno al2= new Alumno("Ezequiel","Ringuelet",new Date(21,9,1993),123456,"ezeringue@gmail.com",3,"ezeringue","123","12000/1");
		Alumno al3= new Alumno("Luciano","La Frazia",new Date(),321654,"ellucho@gmail.com",3,"lucholafrazia","123","11900/1");
		
		guardarAlumnos(al1,al2,al3);
		
		//Creamos Profesores
		Profesor p1 = new Profesor("Laura","Fava",new Date(),12345678,"laurafava@gmail.com",2,"laurafava","123");
		Profesor p2 = new Profesor("Gustavo","Rossi",new Date(),12345678,"gustavorossi@gmail.com",2,"grossi","123");
		Profesor p3 = new Profesor("Juan Pablo","Perez",new Date(),12345678,"jppez@gmail.com",2,"jpperez","123");
		
		guardarProfesores(p1,p2,p3);
		
		//Creamos Publicadores
		Publicador pu1 = new Publicador("Publicador","1",new Date(),12345678,"publicador1@gmail.com",4,"publicador1","123");
		Publicador pu2 = new Publicador("Publicador","2",new Date(),12345678,"publicador2@gmail.com",4,"publicador2","123");
		Publicador pu3 = new Publicador("Publicador","3",new Date(),12345678,"publicador3@gmail.com",4,"publicador3","123");
		
		guardarPublicadores(pu1,pu2,pu3);
		
		//Agregar intereses al alumno Mendivil
		al1.agregarInteres(c8);
		al1.agregarInteres(c4);
		al1.agregarInteres(c5);
		
		//Agregar intereses al alumno Ringuelet
		al2.agregarInteres(c8);
		al2.agregarInteres(c6);
		al2.agregarInteres(c3);
		al2.agregarInteres(c4);
		
		//Agregar intereses al alumno Ringuelet
		al3.agregarInteres(c6);
		al3.agregarInteres(c4);
		al3.agregarInteres(c5);
		
		modificarAlumnos(al1, al2, al3);
		
		//Agregar carteleras habilitadas a la profesora Fava
		p1.agregarCartelera(c2);
		p1.agregarCartelera(c3);
		
		//Agregar carteleras habilitadas al profesor Rossi
		p2.agregarCartelera(c2);
		p2.agregarCartelera(c3);
		p2.agregarCartelera(c4);
		
		//Agregar carteleras habilitadas al profesor Perez
		p3.agregarCartelera(c2);
		p3.agregarCartelera(c3);
		p3.agregarCartelera(c4);
		
		modificarProfesores(p1, p2, p3);
		
		//Agregar carteleras habilitadas al publicador1
		pu1.agregarCartelera(c6);
		pu1.agregarCartelera(c7);
		
		//Agregar carteleras habilitadas al publicador2
		pu2.agregarCartelera(c6);
		pu2.agregarCartelera(c7);
		
		//Agregar carteleras habilitadas al publicador3
		pu3.agregarCartelera(c8);
		
		modificarPublicadores(pu1, pu2, pu3);
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
	
	private void guardarAdministradores(Administrador a1, Administrador a2, Administrador a3){
		try {
			a1 = (Administrador) FactoryDAO.getAdministradorDAO().guardar(a1);
			a2 = (Administrador) FactoryDAO.getAdministradorDAO().guardar(a2);
			a3 = (Administrador) FactoryDAO.getAdministradorDAO().guardar(a3);
			System.out.println("Se guardaron los administradores correctamente");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private void guardarAlumnos(Alumno a1, Alumno a2, Alumno a3){
		try {
			a1 = FactoryDAO.getAlumnoDAO().guardar(a1);
			a2 = FactoryDAO.getAlumnoDAO().guardar(a2);
			a3 = FactoryDAO.getAlumnoDAO().guardar(a3);
			System.out.println("Se guardaron los alumnos correctamente");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private void guardarProfesores(Profesor p1, Profesor p2, Profesor p3){
		try {
			p1 = FactoryDAO.getProfesorDAO().guardar(p1);
			p2 = FactoryDAO.getProfesorDAO().guardar(p2);
			p3 = FactoryDAO.getProfesorDAO().guardar(p3);
			System.out.println("Se guardaron los profesores correctamente");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private void guardarPublicadores(Publicador p1, Publicador p2, Publicador p3){
		try {
			p1 = FactoryDAO.getPublicadorDAO().guardar(p1);
			p2 = FactoryDAO.getPublicadorDAO().guardar(p2);
			p3 = FactoryDAO.getPublicadorDAO().guardar(p3);
			System.out.println("Se guardaron los publicadores correctamente");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private void modificarAlumnos(Alumno a1, Alumno a2, Alumno a3){
		try {
			a1 = FactoryDAO.getAlumnoDAO().modificar(a1);
			a2 = FactoryDAO.getAlumnoDAO().modificar(a2);
			a3 = FactoryDAO.getAlumnoDAO().modificar(a3);
			System.out.println("Se modificaron los alumnos correctamente");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private void modificarPublicadores(Publicador p1, Publicador p2, Publicador p3){
		try {
			p1 = FactoryDAO.getPublicadorDAO().modificar(p1);
			p2 = FactoryDAO.getPublicadorDAO().modificar(p2);
			p3 = FactoryDAO.getPublicadorDAO().modificar(p3);
			System.out.println("Se modificaron los publicadores correctamente");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private void modificarProfesores(Profesor p1, Profesor p2, Profesor p3){
		try {
			p1 = FactoryDAO.getProfesorDAO().modificar(p1);
			p2 = FactoryDAO.getProfesorDAO().modificar(p2);
			p3 = FactoryDAO.getProfesorDAO().modificar(p3);
			System.out.println("Se modificaron los profesores correctamente");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
}

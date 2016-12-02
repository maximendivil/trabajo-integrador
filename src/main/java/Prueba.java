

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ttps.clases.Administrador;
import ttps.clases.Alumno;
import ttps.clases.Cartelera;
import ttps.clases.Comentario;
import ttps.clases.Profesor;
import ttps.clases.Publicacion;
import ttps.clases.Publicador;
import ttps.clasesDAO.FactoryDAO;
import ttps.interfacesDAO.AdministradorDAO;
import ttps.interfacesDAO.AlumnoDAO;
import ttps.interfacesDAO.CarteleraDAO;
import ttps.interfacesDAO.ComentarioDAO;
import ttps.interfacesDAO.ProfesorDAO;
import ttps.interfacesDAO.PublicacionDAO;
import ttps.interfacesDAO.PublicadorDAO;

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
		WebApplicationContext context = WebApplicationContextUtils
	            .getWebApplicationContext(getServletContext());
		
		CarteleraDAO cDAO = context.getBean(CarteleraDAO.class);
		
		//Creamos las carteleras
		Cartelera c = new Cartelera("Ingresantes", new Date());
		Cartelera c1 = new Cartelera("Primer año", new Date());
		Cartelera c2 = new Cartelera("Segundo año", new Date());
		Cartelera c3 = new Cartelera("Tercer año", new Date());
		Cartelera c4 = new Cartelera("Cuarto año", new Date());
		Cartelera c5 = new Cartelera("Quinto año", new Date());
		Cartelera c6 = new Cartelera("Institucional", new Date());
		Cartelera c7 = new Cartelera("Eventos", new Date());
		Cartelera c8 = new Cartelera("Ofrecimientos laborales", new Date());
		
		guardarCarteleras(c,c1,c2,c3,c4,c5,c6,c7,c8,cDAO);
		
		AdministradorDAO aDAO = context.getBean(AdministradorDAO.class);
		
		//Creamos administradores
		Administrador a1 = new Administrador("Facundo","Oreja",new Date(),30123456,"admin1@admin.com",1,"admin1","admin");
		Administrador a2 = new Administrador("Viejo","Cuida Bici",new Date(),30123456,"admin2@admin.com",1,"admin2","admin");
		Administrador a3 = new Administrador("John","Maddog",new Date(),30123456,"admin3@admin.com",1,"admin3","admin");
		
		guardarAdministradores(a1,a2,a3,aDAO);
		
		AlumnoDAO alDAO = context.getBean(AlumnoDAO.class);
		
		//Creamos alumnos
		Alumno al1= new Alumno("Maximiliano","Mendivil",new Date(2,1,1993),36734753,"maximendivil22@gmail.com",3,"maximendivil","123","11982/1");
		Alumno al2= new Alumno("Ezequiel","Ringuelet",new Date(21,9,1993),123456,"ezeringue@gmail.com",3,"ezeringue","123","12000/1");
		Alumno al3= new Alumno("Luciano","La Frazia",new Date(),321654,"ellucho@gmail.com",3,"lucholafrazia","123","11900/1");
		
		guardarAlumnos(al1,al2,al3,alDAO);
		
		ProfesorDAO pDAO = context.getBean(ProfesorDAO.class);
		
		//Creamos Profesores
		Profesor p1 = new Profesor("Laura","Fava",new Date(),12345678,"laurafava@gmail.com",2,"laurafava","123");
		Profesor p2 = new Profesor("Gustavo","Rossi",new Date(),12345678,"gustavorossi@gmail.com",2,"grossi","123");
		Profesor p3 = new Profesor("Juan Pablo","Perez",new Date(),12345678,"jppez@gmail.com",2,"jpperez","123");
		
		guardarProfesores(p1,p2,p3,pDAO);
		
		PublicadorDAO puDAO = context.getBean(PublicadorDAO.class);
		
		//Creamos Publicadores
		Publicador pu1 = new Publicador("Publicador","1",new Date(),12345678,"publicador1@gmail.com",4,"publicador1","123");
		Publicador pu2 = new Publicador("Publicador","2",new Date(),12345678,"publicador2@gmail.com",4,"publicador2","123");
		Publicador pu3 = new Publicador("Publicador","3",new Date(),12345678,"publicador3@gmail.com",4,"publicador3","123");
		
		guardarPublicadores(pu1,pu2,pu3,puDAO);
		
		PublicacionDAO publicacionDAO = context.getBean(PublicacionDAO.class);
		
		//Creamos las publicaciones
		Publicacion publicacion = new Publicacion("Prueba","Es una prueba","casa",new Date(),p1);
		publicacion.setCartelera(c);
		Publicacion publicacion2 = new Publicacion("Prueba2","Es una prueba","casa",new Date(),p2);
		publicacion2.setCartelera(c1);
		Publicacion publicacion3 = new Publicacion("Prueba3","Es una prueba","casa",new Date(),p3);
		publicacion3.setCartelera(c2);
		Publicacion publicacion4 = new Publicacion("Prueba4","Es una prueba","casa",new Date(),pu1);
		publicacion4.setCartelera(c3);
		Publicacion publicacion5 = new Publicacion("Prueba5","Es una prueba","casa",new Date(),pu2);
		publicacion5.setCartelera(c4);
		Publicacion publicacion6 = new Publicacion("Prueba6","Es una prueba","casa",new Date(),pu3);
		publicacion6.setCartelera(c5);
		
		guardarPublicaciones(publicacion,publicacion2,publicacion3,publicacion4,publicacion5,publicacion6,publicacionDAO);
		
		ComentarioDAO coDAO = context.getBean(ComentarioDAO.class);
		
		//Creamos comentarios
		Comentario co1 = new Comentario("Comentario 1",new Date(),al1);
		co1.setPublicacion(publicacion);		
		Comentario co2 = new Comentario("Comentario 2",new Date(),al2);
		co2.setPublicacion(publicacion2);
		Comentario co3 = new Comentario("Comentario 3",new Date(),al3);
		co3.setPublicacion(publicacion3);
		Comentario co4 = new Comentario("Comentario 4",new Date(),p1);
		co4.setPublicacion(publicacion4);
		Comentario co5 = new Comentario("Comentario 5",new Date(),p2);
		co5.setPublicacion(publicacion5);
		Comentario co6 = new Comentario("Comentario 6",new Date(),pu1);
		co6.setPublicacion(publicacion6);
		
		guardarComentarios(co1,co2,co3,co4,co5,co6,coDAO);
		
		//Agregar intereses al alumno Mendivil
		al1.agregarInteres(c8);
		al1.agregarInteres(c4);
		al1.agregarInteres(c5);
		
		//Agregar intereses al alumno Ringuelet
		al2.agregarInteres(c8);
		al2.agregarInteres(c6);
		al2.agregarInteres(c3);
		al2.agregarInteres(c4);
		
		//Agregar intereses al alumno La Frazia
		al3.agregarInteres(c6);
		al3.agregarInteres(c4);
		al3.agregarInteres(c5);
		
		modificarAlumnos(al1, al2, al3, alDAO);
		
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
		
		modificarProfesores(p1, p2, p3, pDAO);
		
		
		//Agregar carteleras habilitadas al publicador1
		pu1.agregarCartelera(c6);
		pu1.agregarCartelera(c7);
		
		//Agregar carteleras habilitadas al publicador2
		pu2.agregarCartelera(c6);
		pu2.agregarCartelera(c7);
		
		//Agregar carteleras habilitadas al publicador3
		pu3.agregarCartelera(c8);
		
		modificarPublicadores(pu1, pu2, pu3, puDAO);
		
		/*
		System.out.println("\nLISTADO DE ALUMNOS:");
		ArrayList<Alumno> alumnos = (ArrayList<Alumno>) FactoryDAO.getAlumnoDAO().obtenerTodos();
		Iterator<Alumno> it = alumnos.iterator();
		Alumno aux;
		while (it.hasNext()){
			aux = it.next();
			System.out.println("Alumno: " + aux.getApellido() + " " + aux.getNombre() + " DNI: " + aux.getDni() + " email: " + aux.getEmail() );
		}		
		
		System.out.println("\nLISTADO DE ADMINISTRADORES:");
		ArrayList<Administrador> administradores = (ArrayList<Administrador>) FactoryDAO.getAdministradorDAO().obtenerTodos();
		Iterator<Administrador> it2 = administradores.iterator();
		Administrador aux2;
		while (it2.hasNext()){
			aux2 = it2.next();
			System.out.println("Administrador: " + aux2.getApellido() + " " + aux2.getNombre() + " DNI: " + aux2.getDni() + " email: " + aux2.getEmail() );
		}
		
		System.out.println("\nLISTADO DE PROFESORES:");
		ArrayList<Profesor> profesores = (ArrayList<Profesor>) FactoryDAO.getProfesorDAO().obtenerTodos();
		Iterator<Profesor> it3 = profesores.iterator();
		Profesor aux3;
		while (it3.hasNext()){
			aux3 = it3.next();
			System.out.println("Profesor: " + aux3.getApellido() + " " + aux3.getNombre() + " DNI: " + aux3.getDni() + " email: " + aux3.getEmail() );
		}
		
		System.out.println("\nLISTADO DE PUBLICADORES:");
		ArrayList<Publicador> publicadores = (ArrayList<Publicador>) FactoryDAO.getPublicadorDAO().obtenerTodos();
		Iterator<Publicador> it4 = publicadores.iterator();
		Publicador aux4;
		while (it4.hasNext()){
			aux4 = it4.next();
			System.out.println("Publicador: " + aux4.getApellido() + " " + aux4.getNombre() + " DNI: " + aux4.getDni() + " email: " + aux4.getEmail() );
		}
		
		System.out.println("\nLISTADO DE CARTELERAS:");
		ArrayList<Cartelera> carteleras = (ArrayList<Cartelera>) FactoryDAO.getCarteleraDAO().obtenerTodos();
		Iterator<Cartelera> it5 = carteleras.iterator();
		Cartelera aux5;
		while (it5.hasNext()){
			aux5 = it5.next();
			System.out.println("Cartelera: " + aux5.getNombre());
		}
		
		System.out.println("\nLISTADO DE PUBLICACIONES:");
		ArrayList<Publicacion> publicaciones = (ArrayList<Publicacion>) FactoryDAO.getPublicacionDAO().obtenerTodos();
		Iterator<Publicacion> it9 = publicaciones.iterator();
		Publicacion aux9;
		while (it9.hasNext()){
			aux9 = it9.next();
			System.out.println("Titulo: " + aux9.getTitulo() + " descripción: " + aux9.getDescripcion());
		}
		
		System.out.println("\nLISTADO DE COMENTARIOS:");
		ArrayList<Comentario> comentarios = (ArrayList<Comentario>) FactoryDAO.getComentarioDAO().obtenerTodos();
		Iterator<Comentario> it10 = comentarios.iterator();
		Comentario aux10;
		while (it10.hasNext()){
			aux10 = it10.next();
			System.out.println("Comentario: " + aux10.getTexto());
		}
		
		System.out.println("\nCARTELERAS QUE PRESENTÓ INTERES EL ALUMNO MENDIVIL:");
		ArrayList<Cartelera> intereses = (ArrayList<Cartelera>) FactoryDAO.getAlumnoDAO().obtenerIntereses(al1.getId());
		Iterator<Cartelera> it6 = intereses.iterator();
		Cartelera aux6;
		while (it6.hasNext()){
			aux6 = it6.next();
			System.out.println("Cartelera: " + aux6.getNombre());
		}
		
		System.out.println("\nCARTELERAS QUE PRESENTÓ INTERES EL ALUMNO RINGUELET:");
		intereses = (ArrayList<Cartelera>) FactoryDAO.getAlumnoDAO().obtenerIntereses(al2.getId());
		it6 = intereses.iterator();
		while (it6.hasNext()){
			aux6 = it6.next();
			System.out.println("Cartelera: " + aux6.getNombre());
		}
		
		System.out.println("\nCARTELERAS QUE PRESENTÓ INTERES EL ALUMNO LA FRAZIA:");
		intereses = (ArrayList<Cartelera>) FactoryDAO.getAlumnoDAO().obtenerIntereses(al3.getId());
		it6 = intereses.iterator();
		while (it6.hasNext()){
			aux6 = it6.next();
			System.out.println("Cartelera: " + aux6.getNombre());
		}
		
		System.out.println("\nCARTELERAS HABILITADAS PARA LA PROFESORA FAVA:");
		ArrayList<Cartelera> habilitadas = (ArrayList<Cartelera>) FactoryDAO.getProfesorDAO().obtenerCarteleras(p1.getId());
		it6 = habilitadas.iterator();
		while (it6.hasNext()){
			aux6 = it6.next();
			System.out.println("Cartelera: " + aux6.getNombre());
		}
		
		System.out.println("\nCARTELERAS HABILITADAS PARA EL PROFESOR ROSSI:");
		habilitadas = (ArrayList<Cartelera>) FactoryDAO.getProfesorDAO().obtenerCarteleras(p2.getId());
		it6 = habilitadas.iterator();
		while (it6.hasNext()){
			aux6 = it6.next();
			System.out.println("Cartelera: " + aux6.getNombre());
		}
		
		System.out.println("\nCARTELERAS HABILITADAS PARA EL PROFESOR PEREZ:");
		habilitadas = (ArrayList<Cartelera>) FactoryDAO.getProfesorDAO().obtenerCarteleras(p3.getId());
		it6 = habilitadas.iterator();
		while (it6.hasNext()){
			aux6 = it6.next();
			System.out.println("Cartelera: " + aux6.getNombre());
		}
		
		System.out.println("\nCARTELERAS HABILITADAS PARA EL PUBLICADOR 1:");
		habilitadas = (ArrayList<Cartelera>) FactoryDAO.getPublicadorDAO().obtenerCarteleras(pu1.getId());
		it6 = habilitadas.iterator();
		while (it6.hasNext()){
			aux6 = it6.next();
			System.out.println("Cartelera: " + aux6.getNombre());
		}
		
		System.out.println("\nCARTELERAS HABILITADAS PARA EL PUBLICADOR 2:");
		habilitadas = (ArrayList<Cartelera>) FactoryDAO.getPublicadorDAO().obtenerCarteleras(pu2.getId());
		it6 = habilitadas.iterator();
		while (it6.hasNext()){
			aux6 = it6.next();
			System.out.println("Cartelera: " + aux6.getNombre());
		}
		
		System.out.println("\nCARTELERAS HABILITADAS PARA EL PUBLICADOR 3:");
		habilitadas = (ArrayList<Cartelera>) FactoryDAO.getPublicadorDAO().obtenerCarteleras(pu3.getId());
		it6 = habilitadas.iterator();
		while (it6.hasNext()){
			aux6 = it6.next();
			System.out.println("Cartelera: " + aux6.getNombre());
		}
		
		try { 
			/*a2 = FactoryDAO.getAdministradorDAO().eliminar(a2.getId());
			pu2 = FactoryDAO.getPublicadorDAO().eliminar(pu2.getId());
			al2 = FactoryDAO.getAlumnoDAO().eliminar(al2.getId());
			p3 = FactoryDAO.getProfesorDAO().eliminar(p3.getId());
			publicacion2 = FactoryDAO.getPublicacionDAO().eliminar(publicacion2.getId());
			co2 = FactoryDAO.getComentarioDAO().eliminar(co2.getId());
			//eliminarCartelera(c8);
			//c8 = FactoryDAO.getCarteleraDAO().eliminar(c8.getId());
			//System.out.println("\nSe borraron los objetos correctamente");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}*/
		
	}
	
	private void eliminarCartelera(Cartelera c){
		//FactoryDAO.getCarteleraDAO().eliminarCartelerasDeIntereses(c.getId());
		//c.setAlumnosInteresados(null);
		FactoryDAO.getCarteleraDAO().eliminar(c);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void guardarCarteleras(Cartelera c, Cartelera c1, Cartelera c2, Cartelera c3, Cartelera c4, Cartelera c5, Cartelera c6, Cartelera c7, Cartelera c8, CarteleraDAO cDAO){
		try {
			c = cDAO.guardar(c);
			c1 = cDAO.guardar(c1);
			c2 = cDAO.guardar(c2);
			c3 = cDAO.guardar(c3);
			c4 = cDAO.guardar(c4);
			c5 = cDAO.guardar(c5);
			c6 = cDAO.guardar(c6);
			c7 = cDAO.guardar(c7);
			c8 = cDAO.guardar(c8);
			System.out.println("Se guardaron las carteleras correctamente");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private void guardarPublicaciones(Publicacion p1, Publicacion p2, Publicacion p3, Publicacion p4, Publicacion p5, Publicacion p6, PublicacionDAO publicacionDAO){
		try {
			p1 = publicacionDAO.guardar(p1);
			p2 = publicacionDAO.guardar(p2);
			p3 = publicacionDAO.guardar(p3);
			p4 = publicacionDAO.guardar(p4);
			p5 = publicacionDAO.guardar(p5);
			p6 = publicacionDAO.guardar(p6);
			System.out.println("Se guardaron las publicaciones correctamente");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private void guardarComentarios(Comentario co1, Comentario co2, Comentario co3, Comentario co4, Comentario co5, Comentario co6, ComentarioDAO coDAO){
		try {
			co1 = coDAO.guardar(co1);
			co2 = coDAO.guardar(co2);
			co3 = coDAO.guardar(co3);
			co4 = coDAO.guardar(co4);
			co5 = coDAO.guardar(co5);
			co6 = coDAO.guardar(co6);
			System.out.println("Se guardaron los comentarios correctamente");
		}
		catch(Exception e){
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
	
	private void guardarAdministradores(Administrador a1, Administrador a2, Administrador a3, AdministradorDAO aDAO){
		try {
			a1 = aDAO.guardar(a1);
			a2 = aDAO.guardar(a2);
			a3 = aDAO.guardar(a3);
			System.out.println("Se guardaron los administradores correctamente");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private void guardarAlumnos(Alumno a1, Alumno a2, Alumno a3, AlumnoDAO alDAO){
		try {
			a1 = alDAO.guardar(a1);
			a2 = alDAO.guardar(a2);
			a3 = alDAO.guardar(a3);
			System.out.println("Se guardaron los alumnos correctamente");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private void guardarProfesores(Profesor p1, Profesor p2, Profesor p3, ProfesorDAO pDAO){
		try {
			p1 = pDAO.guardar(p1);
			p2 = pDAO.guardar(p2);
			p3 = pDAO.guardar(p3);
			System.out.println("Se guardaron los profesores correctamente");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private void guardarPublicadores(Publicador p1, Publicador p2, Publicador p3, PublicadorDAO puDAO){
		try {
			p1 = puDAO.guardar(p1);
			p2 = puDAO.guardar(p2);
			p3 = puDAO.guardar(p3);
			System.out.println("Se guardaron los publicadores correctamente");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private void modificarAlumnos(Alumno a1, Alumno a2, Alumno a3, AlumnoDAO alDAO){
		try {
			a1 = alDAO.modificar(a1);
			a2 = alDAO.modificar(a2);
			a3 = alDAO.modificar(a3);
			System.out.println("Se modificaron los alumnos correctamente");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private void modificarPublicadores(Publicador p1, Publicador p2, Publicador p3, PublicadorDAO puDAO){
		try {
			p1 = puDAO.modificar(p1);
			p2 = puDAO.modificar(p2);
			p3 = puDAO.modificar(p3);
			System.out.println("Se modificaron los publicadores correctamente");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	private void modificarProfesores(Profesor p1, Profesor p2, Profesor p3, ProfesorDAO pDAO){
		try {
			p1 = pDAO.modificar(p1);
			p2 = pDAO.modificar(p2);
			p3 = pDAO.modificar(p3);
			System.out.println("Se modificaron los profesores correctamente");
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
}

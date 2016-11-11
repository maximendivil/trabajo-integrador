package clasesDAO;

import interfacesDAO.*;

public class FactoryDAO {
	
	public static GenericDAO getAdministradorDAO(){
		return new AdministradorDAOHibernateJPA();
	}
	public static AlumnoDAO getAlumnoDAO(){
		return new AlumnoDAOjpa();
	}
	public static ProfesorDAO getProfesorDAO(){
		return new ProfesorDAOjpa();
	}
	public static PublicadorDAO getPublicadorDAO(){
		return new PublicadorDAOjpa();
	}
	public static CarteleraDAO getCarteleraDAO(){
		return new CarteleraDAOjpa();
	}
	public static PublicacionDAO getPublicacionDAO(){
		return new PublicacionDAOjpa();
	}
	public static ComentarioDAO getComentarioDAO(){
		return new ComentarioDAOjpa();
	}
}

package clasesDAO;

import interfacesDAO.*;

public class FactoryDAO {
	
	public static GenericDAO getAdministradorDAO(){
		return new AdministradorDAOHibernateJPA();
	}
	public static AlumnoDAO getAlumnoDAO(){
		return new AlumnoDAOHibernateJPA();
	}
	public static ProfesorDAO getProfesorDAO(){
		return new ProfesorDAOHibernateJPA();
	}
	public static PublicadorDAO getPublicadorDAO(){
		return new PublicadorDAOHibernateJPA();
	}
	public static CarteleraDAO getCarteleraDAO(){
		return new CarteleraDAOHibernateJPA();
	}
	public static PublicacionDAO getPublicacionDAO(){
		return new PublicacionDAOHibernateJPA();
	}
	public static ComentarioDAO getComentarioDAO(){
		return new ComentarioDAOHibernateJPA();
	}
}

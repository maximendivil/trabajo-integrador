package clasesDAO;

import java.io.Serializable;
import java.util.List;

import clases.Alumno;
import clases.Cartelera;
import clases.Publicacion;
import interfacesDAO.CarteleraDAO;

public class CarteleraDAOHibernateJPA extends GenericDAOHibernateJPA<Cartelera> implements CarteleraDAO {
	public CarteleraDAOHibernateJPA(){
		super(Cartelera.class);
	}
	
	@Override
	public List<Publicacion> obtenerPublicaciones(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alumno> obtenerAlumnosInteresados(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

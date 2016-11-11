package clasesDAO;

import java.io.Serializable;
import java.util.List;

import clases.Cartelera;
import clases.Comentario;
import clases.Profesor;
import clases.Publicacion;
import interfacesDAO.ProfesorDAO;

public class ProfesorDAOHibernateJPA extends GenericDAOHibernateJPA<Profesor> implements ProfesorDAO {

	public ProfesorDAOHibernateJPA() {
		super(Profesor.class);
	}
	
	@Override
	public List<Publicacion> obtenerPublicaciones(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cartelera> obtenerCarteleras(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Comentario> obtenerComentarios(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

package clasesDAO;

import java.io.Serializable;
import java.util.List;

import clases.Comentario;
import clases.Publicacion;
import interfacesDAO.PublicacionDAO;

public class PublicacionDAOHibernateJPA extends GenericDAOHibernateJPA<Publicacion> implements PublicacionDAO{
	public PublicacionDAOHibernateJPA(){
		super(Publicacion.class);
	}
	@Override
	public List<Comentario> obtenerComentarios(long id){
		return null;
	}
}

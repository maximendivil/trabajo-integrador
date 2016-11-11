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
	public List<Publicacion> obtenerPublicaciones(Serializable id){
		return null;
	}
	@Override
	public List<Comentario> obtenerComentarios(Serializable id){
		return null;
	}
}

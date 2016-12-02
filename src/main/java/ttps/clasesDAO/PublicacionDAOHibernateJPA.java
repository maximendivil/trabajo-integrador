package ttps.clasesDAO;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import ttps.clases.Comentario;
import ttps.clases.Publicacion;
import ttps.interfacesDAO.PublicacionDAO;

@Repository
public class PublicacionDAOHibernateJPA extends GenericDAOHibernateJPA<Publicacion> implements PublicacionDAO{
	public PublicacionDAOHibernateJPA(){
		super(Publicacion.class);
	}
	@Override
	public List<Comentario> obtenerComentarios(long id){
		return null;
	}
}

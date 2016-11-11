package clasesDAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import clases.Administrador;
import clases.Comentario;
import clases.Publicacion;
import entityManager.EMF;
import interfacesDAO.AdministradorDAO;

public class AdministradorDAOHibernateJPA extends GenericDAOHibernateJPA<Administrador> implements AdministradorDAO {
	public AdministradorDAOHibernateJPA(){
		super(Administrador.class);
	}
	
	@Override
	public List<Publicacion> obtenerPublicaciones(Serializable id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Administrador a INNER JOIN Publicacion p on a.id=p.PERSONA_ID");
		List<Publicacion> resultado = (List<Publicacion>) q.getResultList();
		return resultado;
	}
	
	@Override
	public List<Comentario> obtenerComentarios(Serializable id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Administrador a INNER JOIN Comentario c on a.id=c.PERSONA_ID");
		List<Comentario> resultado = (List<Comentario>) q.getResultList();
		return resultado;
	}
}

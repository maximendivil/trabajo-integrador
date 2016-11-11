package clasesDAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import clases.Cartelera;
import clases.Comentario;
import clases.Profesor;
import clases.Publicacion;
import entityManager.EMF;
import interfacesDAO.ProfesorDAO;

public class ProfesorDAOHibernateJPA extends GenericDAOHibernateJPA<Profesor> implements ProfesorDAO {

	public ProfesorDAOHibernateJPA() {
		super(Profesor.class);
	}
	
	@Override
	public List<Publicacion> obtenerPublicaciones(long id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Profesor pr INNER JOIN Publicacion p on pr.id=p.idP");
		List<Publicacion> resultado = (List<Publicacion>) q.getResultList();
		return resultado;
	}

	@Override
	public List<Cartelera> obtenerCarteleras(long id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Profesor pr INNER JOIN CartelerasHabilitadas ch on pr.id=ch.idP INNER JOIN Cartelera c on ch.idC=c.id");
		List<Cartelera> resultado = (List<Cartelera>) q.getResultList();
		return resultado;
	}

	@Override
	public List<Comentario> obtenerComentarios(long id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Profesor p INNER JOIN Comentario c on a.id=c.idA");
		List<Comentario> resultado = (List<Comentario>) q.getResultList();
		return resultado;
	}

}

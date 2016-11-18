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
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Profesor pr INNER JOIN Publicacion p on pr.id=p.PUBLICADOR_ID");
		List<Publicacion> resultado = (List<Publicacion>) q.getResultList();
		return resultado;
	}

	@Override
	public List<Cartelera> obtenerCarteleras(long id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("SELECT c FROM Profesor p JOIN p.cartelerasHabilitadas c WHERE p.id=:id");
		q.setParameter("id", (int) id);
		List<Cartelera> resultado = (List<Cartelera>) q.getResultList();
		return resultado;
	}

	@Override
	public List<Comentario> obtenerComentarios(long id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Profesor p INNER JOIN Comentario c on a.id=c.PERSONA_ID");
		List<Comentario> resultado = (List<Comentario>) q.getResultList();
		return resultado;
	}

}

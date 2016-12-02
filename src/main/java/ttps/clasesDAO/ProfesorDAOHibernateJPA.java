package ttps.clasesDAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.clases.Cartelera;
import ttps.clases.Comentario;
import ttps.clases.Profesor;
import ttps.clases.Publicacion;
import ttps.entityManager.EMF;
import ttps.interfacesDAO.ProfesorDAO;

@Repository
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
		q.setParameter("id", id);
		List<Cartelera> resultado = (List<Cartelera>) q.getResultList();
		return resultado;
	}

}

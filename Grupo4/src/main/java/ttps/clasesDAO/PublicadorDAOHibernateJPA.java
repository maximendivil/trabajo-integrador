package ttps.clasesDAO;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.clases.Cartelera;
import ttps.clases.Comentario;
import ttps.clases.Publicacion;
import ttps.clases.Publicador;
import ttps.entityManager.EMF;
import ttps.interfacesDAO.PublicadorDAO;

@Repository
public class PublicadorDAOHibernateJPA extends GenericDAOHibernateJPA<Publicador> implements PublicadorDAO {
	
	public PublicadorDAOHibernateJPA() {
		super(Publicador.class);
	}
	
	@Override
	public List<Publicacion> obtenerPublicaciones(long id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("SELECT c FROM Publicador p JOIN p.cartelerasHabilitadas c WHERE p.id=:id");
		q.setParameter("id", id);
		List<Publicacion> resultado = (List<Publicacion>) q.getResultList();
		return resultado;
	}

	@Override
	public List<Cartelera> obtenerCarteleras(long id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("SELECT c FROM Publicador p JOIN p.cartelerasHabilitadas c WHERE p.id=:id");
		q.setParameter("id", id);
		List<Cartelera> resultado = (List<Cartelera>) q.getResultList();
		return resultado;
	}
}

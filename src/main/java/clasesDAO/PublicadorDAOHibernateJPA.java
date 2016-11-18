package clasesDAO;

import java.util.List;

import javax.persistence.Query;

import clases.Cartelera;
import clases.Comentario;
import clases.Publicacion;
import clases.Publicador;
import entityManager.EMF;
import interfacesDAO.PublicadorDAO;

public class PublicadorDAOHibernateJPA extends GenericDAOHibernateJPA<Publicador> implements PublicadorDAO {
	
	public PublicadorDAOHibernateJPA() {
		super(Publicador.class);
	}
	
	@Override
	public List<Publicacion> obtenerPublicaciones(long id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("SELECT c FROM Publicador p JOIN p.cartelerasHabilitadas c WHERE p.id=:id");
		q.setParameter("id", (int) id);
		List<Publicacion> resultado = (List<Publicacion>) q.getResultList();
		return resultado;
	}

	@Override
	public List<Cartelera> obtenerCarteleras(long id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("SELECT c FROM Publicador p JOIN p.cartelerasHabilitadas c WHERE p.id=:id");
		q.setParameter("id", (int) id);
		List<Cartelera> resultado = (List<Cartelera>) q.getResultList();
		return resultado;
	}

	@Override
	public List<Comentario> obtenerComentarios(long id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Publicador p INNER JOIN Comentario c on p.id=c.PERSONA_ID");
		List<Comentario> resultado = (List<Comentario>) q.getResultList();
		return resultado;
	}
}

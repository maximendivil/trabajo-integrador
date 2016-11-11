package clasesDAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import clases.Alumno;
import clases.Cartelera;
import clases.Comentario;
import clases.Publicacion;
import entityManager.EMF;
import interfacesDAO.CarteleraDAO;

public class CarteleraDAOHibernateJPA extends GenericDAOHibernateJPA<Cartelera> implements CarteleraDAO {
	public CarteleraDAOHibernateJPA(){
		super(Cartelera.class);
	}
	
	@Override
	public List<Publicacion> obtenerPublicaciones(long id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Cartelera c INNER JOIN Publicacion p on c.id=p.idC");
		List<Publicacion> resultado = (List<Publicacion>) q.getResultList();
		return resultado;
	}

	@Override
	public List<Alumno> obtenerAlumnosInteresados(long id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Cartelera c INNER JOIN Intereses i on c.id=i.idC");
		List<Alumno> resultado = (List<Alumno>) q.getResultList();
		return resultado;
	}

}

package clasesDAO;

import java.util.List;

import javax.persistence.Query;

import clases.*;
import entityManager.EMF;
import interfacesDAO.AdministradorDAO;

public class AdministradorDAOHibernateJPA extends GenericDAOHibernateJPA<Administrador> implements AdministradorDAO {
	
	public AdministradorDAOHibernateJPA(){
		super(Administrador.class);
	}
	
	@Override
	public List<Publicacion> obtenerPublicaciones(long id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Administrador a INNER JOIN Publicacion p on a.id=p.PERSONA_ID");
		List<Publicacion> resultado = (List<Publicacion>) q.getResultList();
		return resultado;
	}
}

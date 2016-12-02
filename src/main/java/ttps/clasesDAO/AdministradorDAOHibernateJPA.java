package ttps.clasesDAO;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.clases.*;
import ttps.entityManager.EMF;
import ttps.interfacesDAO.AdministradorDAO;

@Repository
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

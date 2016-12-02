package ttps.clasesDAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.clases.Alumno;
import ttps.clases.Cartelera;
import ttps.clases.Comentario;
import ttps.entityManager.EMF;
import ttps.interfacesDAO.AlumnoDAO;

@Repository
public class AlumnoDAOHibernateJPA extends GenericDAOHibernateJPA<Alumno> implements AlumnoDAO {	
	
	public AlumnoDAOHibernateJPA(){
		super(Alumno.class);
	}

	@Override
	public List<Cartelera> obtenerIntereses(long id) { //Ver como guardar intereses
		Query q = EMF.getEMF().createEntityManager().createQuery("SELECT i FROM Alumno a INNER JOIN a.intereses i WHERE a.id=:id");
		q.setParameter("id",id);
		List<Cartelera> resultado = (List<Cartelera>) q.getResultList();
		return resultado;
	}

}

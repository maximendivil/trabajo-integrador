package clasesDAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import clases.Alumno;
import clases.Cartelera;
import clases.Comentario;
import entityManager.EMF;
import interfacesDAO.AlumnoDAO;

public class AlumnoDAOHibernateJPA extends GenericDAOHibernateJPA<Alumno> implements AlumnoDAO {	
	
	public AlumnoDAOHibernateJPA(){
		super(Alumno.class);
	}
	
	@Override
	public List<Comentario> obtenerComentarios(long id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Alumno a INNER JOIN Comentario c on a.id=c.idP");
		List<Comentario> resultado = (List<Comentario>) q.getResultList();
		return resultado;
	}

	@Override
	public List<String> obtenerIntereses(long id) { //Ver como guardar intereses
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Alumno a INNER JOIN Interes i on a.id=i.idP");
		List<String> resultado = (List<String>) q.getResultList();
		return resultado;
	}

}

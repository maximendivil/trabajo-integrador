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
<<<<<<< HEAD
	public List<Comentario> obtenerComentarios(int id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Alumno a INNER JOIN Comentario c on a.id=c.PERSONA_ID");
=======
	public List<Comentario> obtenerComentarios(long id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Alumno a INNER JOIN Comentario c on a.id=c.idP");
>>>>>>> fbd16c768546a894b758d4d1b4f13e0e76e0468e
		List<Comentario> resultado = (List<Comentario>) q.getResultList();
		return resultado;
	}

	@Override
<<<<<<< HEAD
	public List<String> obtenerIntereses(int id) { //Ver como guardar intereses
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Alumno a INNER JOIN Interes i on a.id=i.PERSONA_ID");
=======
	public List<String> obtenerIntereses(long id) { //Ver como guardar intereses
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Alumno a INNER JOIN Interes i on a.id=i.idP");
>>>>>>> fbd16c768546a894b758d4d1b4f13e0e76e0468e
		List<String> resultado = (List<String>) q.getResultList();
		return resultado;
	}

}

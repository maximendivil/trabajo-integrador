package clasesDAO;

import java.io.Serializable;
import java.util.List;

import clases.Alumno;
import clases.Cartelera;
import clases.Comentario;
import interfacesDAO.AlumnoDAO;

public class AlumnoDAOHibernateJPA extends GenericDAOHibernateJPA<Alumno> implements AlumnoDAO {	
	
	public AlumnoDAOHibernateJPA(){
		super(Alumno.class);
	}
	
	@Override
	public List<Comentario> obtenerComentarios(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cartelera> obtenerIntereses(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

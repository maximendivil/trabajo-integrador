package ttps.interfacesDAO;

import java.util.List;

import ttps.clases.Alumno;
import ttps.clases.Cartelera;
import ttps.clases.Comentario;

public interface AlumnoDAO extends GenericDAO<Alumno>{	
	List<Cartelera> obtenerIntereses(long id); // Ver como se guardan los intereses.
}

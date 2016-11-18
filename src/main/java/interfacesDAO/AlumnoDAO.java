package interfacesDAO;

import java.util.List;

import clases.Alumno;
import clases.Cartelera;
import clases.Comentario;

public interface AlumnoDAO extends GenericDAO<Alumno>{
	List<Comentario> obtenerComentarios(long id);
	List<Cartelera> obtenerIntereses(long id); // Ver como se guardan los intereses.
}

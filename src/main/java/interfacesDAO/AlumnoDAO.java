package interfacesDAO;

import java.util.List;

import clases.Alumno;
import clases.Cartelera;
import clases.Comentario;

public interface AlumnoDAO extends GenericDAO<Alumno>{
	List<Comentario> obtenerComentarios(int id);
	List<Cartelera> obtenerIntereses(int id);
}

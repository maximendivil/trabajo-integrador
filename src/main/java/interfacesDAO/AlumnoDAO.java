package interfacesDAO;

import java.util.List;

import clases.Alumno;
import clases.Cartelera;
import clases.Comentario;

public interface AlumnoDAO {
	List<Alumno> obtenerTodos();
	List<Comentario> obtenerComentarios(int id);
	List<Cartelera> obtenerIntereses(int id);
	Alumno obtener(int id);
	void eliminar(int id);
	void guardar(Alumno alumno);
}

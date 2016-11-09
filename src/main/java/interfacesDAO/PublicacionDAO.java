package interfacesDAO;

import java.util.List;

import clases.Cartelera;
import clases.Comentario;
import clases.Profesor;
import clases.Publicacion;

public interface PublicacionDAO {
	List<Publicacion> obtenerTodos();
	Publicacion obtener(int id);
	List<Publicacion> obtenerPublicaciones(int id);
	List<Comentario> obtenerComentarios(int id);
	void eliminar(int id);
	void guardar(Publicacion publicacion);
}

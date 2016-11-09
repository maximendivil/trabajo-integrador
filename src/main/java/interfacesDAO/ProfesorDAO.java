package interfacesDAO;

import java.util.List;

import clases.*;

public interface ProfesorDAO {
	List<Profesor> obtenerTodos();
	Profesor obtener(int id);
	List<Publicacion> obtenerPublicaciones(int id);
	List<Cartelera> obtenerCarteleras(int id);
	List<Comentario> obtenerComentarios(int id);
	void eliminar(int id);
	void guardar(Profesor profesor);
}

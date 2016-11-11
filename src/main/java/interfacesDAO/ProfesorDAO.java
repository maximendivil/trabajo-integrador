package interfacesDAO;

import java.util.List;

import clases.*;

public interface ProfesorDAO extends GenericDAO {
	List<Publicacion> obtenerPublicaciones(int id);
	List<Cartelera> obtenerCarteleras(int id);
	List<Comentario> obtenerComentarios(int id);
}

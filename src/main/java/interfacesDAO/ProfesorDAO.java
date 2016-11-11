package interfacesDAO;

import java.io.Serializable;
import java.util.List;

import clases.*;

public interface ProfesorDAO extends GenericDAO<Profesor> {
	List<Publicacion> obtenerPublicaciones(long id);
	List<Cartelera> obtenerCarteleras(long id);
	List<Comentario> obtenerComentarios(long id);
}

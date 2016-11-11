package interfacesDAO;

import java.io.Serializable;
import java.util.List;

import clases.*;

public interface ProfesorDAO extends GenericDAO<Profesor> {
	List<Publicacion> obtenerPublicaciones(Serializable id);
	List<Cartelera> obtenerCarteleras(Serializable id);
	List<Comentario> obtenerComentarios(Serializable id);
}

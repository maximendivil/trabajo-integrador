package interfacesDAO;

import java.io.Serializable;
import java.util.List;

import clases.Cartelera;
import clases.Comentario;
import clases.Persona;
import clases.Profesor;
import clases.Publicacion;

public interface PublicacionDAO extends GenericDAO<Publicacion>{
	List<Publicacion> obtenerPublicaciones(Serializable id);
	List<Comentario> obtenerComentarios(Serializable id);
}

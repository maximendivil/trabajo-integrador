package interfacesDAO;

import java.util.List;

import clases.Cartelera;
import clases.Comentario;
import clases.Publicacion;
import clases.Publicador;

public interface PublicadorDAO extends GenericDAO<Publicador> {
	List<Publicacion> obtenerPublicaciones(long id);
	List<Cartelera> obtenerCarteleras(long id);
	List<Comentario> obtenerComentarios(long id);
}

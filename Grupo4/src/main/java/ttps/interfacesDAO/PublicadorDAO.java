package ttps.interfacesDAO;

import java.util.List;

import ttps.clases.Cartelera;
import ttps.clases.Comentario;
import ttps.clases.Publicacion;
import ttps.clases.Publicador;

public interface PublicadorDAO extends GenericDAO<Publicador> {
	List<Publicacion> obtenerPublicaciones(long id);
	List<Cartelera> obtenerCarteleras(long id);
}

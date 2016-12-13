package ttps.interfacesDAO;

import java.io.Serializable;
import java.util.List;

import ttps.clases.Cartelera;
import ttps.clases.Comentario;
import ttps.clases.Persona;
import ttps.clases.Profesor;
import ttps.clases.Publicacion;

public interface PublicacionDAO extends GenericDAO<Publicacion>{
	List<Comentario> obtenerComentarios(long id);
	void remover(long id);
}

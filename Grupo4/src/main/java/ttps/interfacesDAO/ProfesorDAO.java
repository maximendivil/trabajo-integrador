package ttps.interfacesDAO;

import java.io.Serializable;
import java.util.List;

import ttps.clases.*;

public interface ProfesorDAO extends GenericDAO<Profesor> {
	List<Publicacion> obtenerPublicaciones(long id);
	List<Cartelera> obtenerCarteleras(long id);
}

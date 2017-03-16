package ttps.interfacesDAO;

import java.util.List;

import ttps.clases.Administrador;
import ttps.clases.Comentario;
import ttps.clases.Publicacion;

public interface AdministradorDAO extends GenericDAO<Administrador>{
	List<Publicacion> obtenerPublicaciones(long id);
}

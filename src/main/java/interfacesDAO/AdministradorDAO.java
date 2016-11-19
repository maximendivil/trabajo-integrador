package interfacesDAO;

import java.util.List;

import clases.Administrador;
import clases.Comentario;
import clases.Publicacion;

public interface AdministradorDAO extends GenericDAO<Administrador>{
	List<Publicacion> obtenerPublicaciones(long id);
}

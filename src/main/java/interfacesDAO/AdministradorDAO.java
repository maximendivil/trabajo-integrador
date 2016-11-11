package interfacesDAO;

import java.io.Serializable;
import java.util.List;

import clases.Administrador;
import clases.Comentario;
import clases.Publicacion;

public interface AdministradorDAO extends GenericDAO<Administrador>{
	List<Publicacion> obtenerPublicaciones(Serializable id);
	List<Comentario> obtenerComentarios(Serializable id);
}

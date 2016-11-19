package interfacesDAO;

import java.util.List;

import clases.*;
import clasesDAO.*;

public interface CarteleraDAO extends GenericDAO<Cartelera>{
	List<Publicacion> obtenerPublicaciones(long id);
	List<Alumno> obtenerAlumnosInteresados(long id);
	void eliminarCartelerasDeIntereses(long id);
	void eliminar(Cartelera entity);
}

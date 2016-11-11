package interfacesDAO;

import java.util.List;

import clases.*;

public interface CarteleraDAO extends GenericDAO<Cartelera>{
	List<Publicacion> obtenerPublicaciones(long id);
	List<Alumno> obtenerAlumnosInteresados(long id);
}

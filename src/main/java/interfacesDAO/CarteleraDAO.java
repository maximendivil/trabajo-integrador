package interfacesDAO;

import java.util.List;

import clases.*;

public interface CarteleraDAO extends GenericDAO{
	List<Publicacion> obtenerPublicaciones(int id);
	List<Alumno> obtenerAlumnosInteresados(int id);
}

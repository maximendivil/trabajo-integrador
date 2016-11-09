package interfacesDAO;

import java.util.List;

import clases.*;

public interface CarteleraDAO {
	List<Cartelera> obtenerTodos();
	Cartelera obtener(int id);
	List<Publicacion> obtenerPublicaciones(int id);
	List<Alumno> obtenerAlumnosInteresados(int id);
	void eliminar(int id);
	void guardar(Cartelera cartelera);
}

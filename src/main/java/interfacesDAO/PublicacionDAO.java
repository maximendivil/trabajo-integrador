package interfacesDAO;

import java.util.List;

import clases.Cartelera;
import clases.Comentario;
import clases.Profesor;
import clases.Publicacion;

public interface PublicacionDAO {
	List<Publicacion> obtenerPublicaciones(int id);
	List<Comentario> obtenerComentarios(int id);
}

package ttps.interfacesDAO;

import java.io.Serializable;
import java.util.List;

import ttps.clases.Comentario;

public interface GenericDAO<T> {
	List<T> obtenerTodos();
	T obtener(long id);
	T eliminar(long id);
	T guardar(T entity);
	T modificar(T entity);
	List<Comentario> obtenerComentarios(long id);
}

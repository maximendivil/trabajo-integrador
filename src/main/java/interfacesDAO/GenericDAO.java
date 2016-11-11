package interfacesDAO;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T> {
	List<T> obtenerTodos();
	T obtener(long id);
	T eliminar(long id);
	T guardar(T entity);
}

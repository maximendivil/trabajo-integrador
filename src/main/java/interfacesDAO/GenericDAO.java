package interfacesDAO;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T> {
	List<T> obtenerTodos();
	T obtener(Serializable id);
	T eliminar(Serializable id);
	T guardar(T entity);
}

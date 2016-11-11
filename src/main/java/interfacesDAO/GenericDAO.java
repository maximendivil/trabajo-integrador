package interfacesDAO;

import java.util.List;

public interface GenericDAO<T> {
	List<T> obtenerTodos();
	T obtener(int id);
	void eliminar(int id);
	void guardar(T type);
}

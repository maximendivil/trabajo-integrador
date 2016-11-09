package interfacesDAO;

import java.util.List;

import clases.Publicador;

public interface PublicadorDAO {
	List<Publicador> obtenerTodos();
	Publicador obtener(int id);
	void eliminar(int id);
	void guardar(Publicador publicador);
}

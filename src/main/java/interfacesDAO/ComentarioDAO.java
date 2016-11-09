package interfacesDAO;

import java.util.List;

import clases.Comentario;

public interface ComentarioDAO {
	List<Comentario> obtenerTodos();
	Comentario obtener(int id);
	void eliminar(int id);
	void guardar(Comentario comentario);
}

package interfacesDAO;

import java.util.List;

import clases.Administrador;

public interface AdministradorDAO {
	List<Administrador> obtenerTodos();
	Administrador obtener(int id);
	void eliminar(int id);
	void guardar(Administrador admin);
}


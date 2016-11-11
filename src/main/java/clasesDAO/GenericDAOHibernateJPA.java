package clasesDAO;

import java.util.List;

import interfacesDAO.GenericDAO;

public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {

	@Override
	public List<T> obtenerTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T obtener(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void guardar(T type) {
		// TODO Auto-generated method stub

	}

}

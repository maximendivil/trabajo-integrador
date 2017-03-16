package ttps.interfacesDAO;

import ttps.clases.Administrador;
import ttps.clases.Persona;

public interface PersonaDAO extends GenericDAO<Persona>{
	public Persona login(String userLogin, String password);
	public void logout(Persona user);
	public Persona obtenerPorUsuario(String usuario);
	public int buscarRol(String usuario);
}

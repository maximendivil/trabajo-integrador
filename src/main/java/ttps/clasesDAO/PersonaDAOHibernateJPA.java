package ttps.clasesDAO;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ttps.clases.Administrador;
import ttps.clases.Persona;
import ttps.clases.Publicacion;
import ttps.entityManager.EMF;
import ttps.interfacesDAO.AdministradorDAO;
import ttps.interfacesDAO.PersonaDAO;

@Repository
public class PersonaDAOHibernateJPA extends GenericDAOHibernateJPA<Persona> implements PersonaDAO{
	public PersonaDAOHibernateJPA(){
		super(Persona.class);
	}
	
	@Override
	public Persona login(String userLogin, String password){
		Persona u = this.obtenerPorUsuario(userLogin);
		System.out.println(u.getUsuario());
		if(u != null){
			if(u.getPassword().equals(password)){
				return u;
			}
		}
		
		throw new IllegalArgumentException("Usuario o password invalido");
	}
	
	@Override
	public Persona obtenerPorUsuario(String usuario){
		Query q = this.getEntityManager().createQuery("from " + getPersistentClass().getSimpleName() + " Where usuario = :usuario");
		q.setParameter("usuario", usuario);
		Persona resultado = (Persona) q.getSingleResult();
		return resultado;
	}
	
	@Override
	public void logout(Persona user) {
		
	}
	
	@Override
	public int buscarRol(String usuario){
		Query q = this.getEntityManager().createQuery("select rol from " + getPersistentClass().getSimpleName() + " Where usuario = :usuario");
		q.setParameter("usuario", usuario);
		int resultado = (int) q.getSingleResult();
		return resultado;
	}
}

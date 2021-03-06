package ttps.clasesDAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.transaction.annotation.Transactional;

import ttps.clases.Comentario;
import ttps.clases.Publicacion;
import ttps.entityManager.EMF;
import ttps.interfacesDAO.GenericDAO;

@Transactional
public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {

	protected Class<T> persistentClass;
	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em){
		this.entityManager = em;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
		
	public GenericDAOHibernateJPA(Class<T> entity){
		this.persistentClass = entity;
	}
	
	@Override
	public List<T> obtenerTodos() {
		Query q = this.getEntityManager().createQuery("from " + getPersistentClass().getSimpleName() + " t where t.borrado=0");
		List<T> resultado = (List<T>) q.getResultList();
		return resultado;
	}

	@Override
	public T obtener(long id) {
		Query q = this.getEntityManager().createQuery("from " + getPersistentClass().getSimpleName() + " Where id = :id");
		q.setParameter("id", id);
		T resultado = (T) q.getSingleResult();
		return resultado;
	}

	//@Override
	public T eliminar(long id) {
		T entity = null;
		this.getEntityManager().remove(entity);
		this.getEntityManager().flush();
		return entity;
	}	
	
	private void borrar(T entity) { 
		this.getEntityManager().remove(this.getEntityManager().merge(entity));
	}	

	@Override
	public T guardar(T entity) {
		this.getEntityManager().persist(entity);
		return entity;
	}
	
	@Override
	public T modificar(T entity){
		this.getEntityManager().merge(entity);
		return entity;
	}
	
	@Override
	public List<Comentario> obtenerComentarios(long id){
		Query q = this.getEntityManager().createQuery("from " + getPersistentClass().getSimpleName() + " p where p.id=:id" );
		q.setParameter("id", id);
		List<Comentario> resultado = (List<Comentario>) q.getResultList();
		return resultado;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

}

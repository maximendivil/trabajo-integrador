package clasesDAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entityManager.EMF;
import interfacesDAO.GenericDAO;

public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {

	protected Class<T> persistentClass;
	
	public GenericDAOHibernateJPA(Class<T> entity){
		this.persistentClass = entity;
	}
	
	@Override
	public List<T> obtenerTodos() {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from " + getPersistentClass().getSimpleName());
		List<T> resultado = (List<T>) q.getResultList();
		return resultado;
	}

	@Override
	public T obtener(long id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from " + getPersistentClass().getSimpleName() + "Where id = :id");
		q.setParameter("id", id);
		T resultado = (T) q.getSingleResult();
		return resultado;
	}

	@Override
	public T eliminar(long id) {
		T entity = EMF.getEMF().createEntityManager().find(this.getPersistentClass(), id);
		if (entity != null) {
			this.borrar(entity); 
		} 
		return entity; 
	}
	
	public void borrar(T entity) { 
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction tx = null;
		try { 
			tx = em.getTransaction();
			tx.begin();
			em.remove(entity);
			tx.commit();
		} 
		catch (RuntimeException e) { 
			if ( tx != null && tx.isActive() ) { 
				tx.rollback();
				System.out.println(e.getMessage());
				throw e;
				// escribir en un log o mostrar un mensaje } }
			}
		}
		finally { 
			em.close(); 
		}
	}	

	@Override
	public T guardar(T entity) {
		EntityManager em = EMF.getEMF().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(entity);
			tx.commit();
		}
		catch (RuntimeException e) {
			if ( tx != null && tx.isActive() ) {
				tx.rollback();
				System.out.println(e.getMessage());
				throw e;
			}
		}
		finally { 
			em.close();
		}
		return entity;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

}

package clasesDAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import clases.Cartelera;
import clases.Comentario;
import clases.Profesor;
import clases.Publicacion;
import entityManager.EMF;
import interfacesDAO.ProfesorDAO;

public class ProfesorDAOHibernateJPA extends GenericDAOHibernateJPA<Profesor> implements ProfesorDAO {

	public ProfesorDAOHibernateJPA() {
		super(Profesor.class);
	}
	
	@Override
<<<<<<< HEAD
	public List<Publicacion> obtenerPublicaciones(Serializable id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Profesor pr INNER JOIN Publicacion p on pr.id=p.PUBLICADOR_ID");
=======
	public List<Publicacion> obtenerPublicaciones(long id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Profesor pr INNER JOIN Publicacion p on pr.id=p.idP");
>>>>>>> fbd16c768546a894b758d4d1b4f13e0e76e0468e
		List<Publicacion> resultado = (List<Publicacion>) q.getResultList();
		return resultado;
	}

	@Override
<<<<<<< HEAD
	public List<Cartelera> obtenerCarteleras(Serializable id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Profesor pr INNER JOIN CartelerasHabilitadas ch on pr.id=ch.PUBLICADOR_ID INNER JOIN Cartelera c on ch.CARTELERA_ID=c.id");
=======
	public List<Cartelera> obtenerCarteleras(long id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Profesor pr INNER JOIN CartelerasHabilitadas ch on pr.id=ch.idP INNER JOIN Cartelera c on ch.idC=c.id");
>>>>>>> fbd16c768546a894b758d4d1b4f13e0e76e0468e
		List<Cartelera> resultado = (List<Cartelera>) q.getResultList();
		return resultado;
	}

	@Override
<<<<<<< HEAD
	public List<Comentario> obtenerComentarios(Serializable id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Profesor p INNER JOIN Comentario c on a.id=c.PERSONA_ID");
=======
	public List<Comentario> obtenerComentarios(long id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Profesor p INNER JOIN Comentario c on a.id=c.idA");
>>>>>>> fbd16c768546a894b758d4d1b4f13e0e76e0468e
		List<Comentario> resultado = (List<Comentario>) q.getResultList();
		return resultado;
	}

}

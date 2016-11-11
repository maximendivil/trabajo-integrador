package clasesDAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import clases.Alumno;
import clases.Cartelera;
import clases.Comentario;
import clases.Publicacion;
import entityManager.EMF;
import interfacesDAO.CarteleraDAO;

public class CarteleraDAOHibernateJPA extends GenericDAOHibernateJPA<Cartelera> implements CarteleraDAO {
	public CarteleraDAOHibernateJPA(){
		super(Cartelera.class);
	}
	
	@Override
<<<<<<< HEAD
	public List<Publicacion> obtenerPublicaciones(int id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Cartelera c INNER JOIN Publicacion p on c.id=p.CARTELERA_ID");
=======
	public List<Publicacion> obtenerPublicaciones(long id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Cartelera c INNER JOIN Publicacion p on c.id=p.idC");
>>>>>>> fbd16c768546a894b758d4d1b4f13e0e76e0468e
		List<Publicacion> resultado = (List<Publicacion>) q.getResultList();
		return resultado;
	}

	@Override
<<<<<<< HEAD
	public List<Alumno> obtenerAlumnosInteresados(int id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Cartelera c INNER JOIN Intereses i on c.id=i.CARTELERA_ID");
=======
	public List<Alumno> obtenerAlumnosInteresados(long id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Cartelera c INNER JOIN Intereses i on c.id=i.idC");
>>>>>>> fbd16c768546a894b758d4d1b4f13e0e76e0468e
		List<Alumno> resultado = (List<Alumno>) q.getResultList();
		return resultado;
	}

}

package clasesDAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import clases.Administrador;
import clases.Comentario;
import clases.Publicacion;
import entityManager.EMF;
import interfacesDAO.AdministradorDAO;

public class AdministradorDAOHibernateJPA extends GenericDAOHibernateJPA<Administrador> implements AdministradorDAO {
	public AdministradorDAOHibernateJPA(){
		super(Administrador.class);
	}
	
	@Override
<<<<<<< HEAD
	public List<Publicacion> obtenerPublicaciones(Serializable id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Administrador a INNER JOIN Publicacion p on a.id=p.PERSONA_ID");
=======
	public List<Publicacion> obtenerPublicaciones(long id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Administrador a INNER JOIN Publicacion p on a.id=p.idP");
>>>>>>> fbd16c768546a894b758d4d1b4f13e0e76e0468e
		List<Publicacion> resultado = (List<Publicacion>) q.getResultList();
		return resultado;
	}
	
	@Override
<<<<<<< HEAD
	public List<Comentario> obtenerComentarios(Serializable id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Administrador a INNER JOIN Comentario c on a.id=c.PERSONA_ID");
=======
	public List<Comentario> obtenerComentarios(long id) {
		Query q = EMF.getEMF().createEntityManager().createQuery("Select * from Administrador a INNER JOIN Comentario c on a.id=c.idP");
>>>>>>> fbd16c768546a894b758d4d1b4f13e0e76e0468e
		List<Comentario> resultado = (List<Comentario>) q.getResultList();
		return resultado;
	}
}

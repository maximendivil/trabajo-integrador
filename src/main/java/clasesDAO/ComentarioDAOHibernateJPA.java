package clasesDAO;

import java.io.Serializable;
import java.util.List;

import clases.Comentario;
import interfacesDAO.ComentarioDAO;

public class ComentarioDAOHibernateJPA extends GenericDAOHibernateJPA<Comentario> implements ComentarioDAO {

	public ComentarioDAOHibernateJPA(){
		super(Comentario.class);
	}

}

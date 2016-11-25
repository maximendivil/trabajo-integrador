package clasesDAO;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import clases.Comentario;
import interfacesDAO.ComentarioDAO;

@Repository
public class ComentarioDAOHibernateJPA extends GenericDAOHibernateJPA<Comentario> implements ComentarioDAO {

	public ComentarioDAOHibernateJPA(){
		super(Comentario.class);
	}

}

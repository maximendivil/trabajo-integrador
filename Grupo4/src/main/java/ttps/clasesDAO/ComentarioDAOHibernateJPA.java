package ttps.clasesDAO;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import ttps.clases.Comentario;
import ttps.interfacesDAO.ComentarioDAO;

@Repository
public class ComentarioDAOHibernateJPA extends GenericDAOHibernateJPA<Comentario> implements ComentarioDAO {

	public ComentarioDAOHibernateJPA(){
		super(Comentario.class);
	}

}

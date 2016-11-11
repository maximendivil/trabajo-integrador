package clasesDAO;

import clases.Publicador;
import interfacesDAO.PublicadorDAO;

public class PublicadorDAOHibernateJPA extends GenericDAOHibernateJPA<Publicador> implements PublicadorDAO {
	
	public PublicadorDAOHibernateJPA() {
		super(Publicador.class);
	}
}

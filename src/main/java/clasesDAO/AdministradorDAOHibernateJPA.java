package clasesDAO;

import clases.Administrador;
import interfacesDAO.AdministradorDAO;

public class AdministradorDAOHibernateJPA extends GenericDAOHibernateJPA<Administrador> implements AdministradorDAO {
	public AdministradorDAOHibernateJPA(){
		super(Administrador.class);
	}
}

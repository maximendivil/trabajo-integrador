package ttps.entityManager;

import javax.persistence.*;

public class EMF {
	private static final EntityManagerFactory em = Persistence.createEntityManagerFactory("persistencia");
	
	public static EntityManagerFactory getEMF(){
		return em;
	}
}

package no.hvl.dat107.innlevering3;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AvdelingDAO {
	
	public static Avdeling finnAvdelingMedId(int avdelingsid) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ansattPersistenceUnit", 
				Map.of("javax.persistence.jdbc.password", "12345"));

        EntityManager em = emf.createEntityManager();

        Avdeling A = null;
        
        try {
            A = em.find(Avdeling.class, avdelingsid);

        } finally {
            em.close();
        }

        return A;
	}
	
	public static Ansatt FinnSjef(Integer avdelingsid) {
		Integer p = finnAvdelingMedId(avdelingsid).getAvdelingssjef();
		return AnsattDAO.finnPersonMedId(p);
	}
	
	public static List<Ansatt> UtlistingAvAnsatteIAvdeling(Integer avdelingsid) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ansattPersistenceUnit", 
				Map.of("javax.persistence.jdbc.password", "12345"));
		
		EntityManager em = emf.createEntityManager();
		
		String queryString = "select a from Ansatt a where a.avdelingsid = :avdelingsid";
		
		System.out.println(FinnSjef(avdelingsid));
		
		try {
			
			em.getTransaction().begin();
			TypedQuery<Ansatt> query = em.createQuery(queryString, Ansatt.class);
			query.setParameter("avdelingsid", avdelingsid);
			em.getTransaction().commit();

			return query.getResultList();
			
		} catch (Exception e) {
			return null;

		} finally {
			em.close();
		}
	}

}

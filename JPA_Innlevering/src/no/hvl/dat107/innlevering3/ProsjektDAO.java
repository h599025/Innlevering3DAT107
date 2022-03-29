package no.hvl.dat107.innlevering3;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ProsjektDAO {

	public static Prosjekt nyProsjekt(Integer prosjektid, String navn, String beskrivelse) {

		EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("ansattPersistenceUnit", 
		Map.of("javax.persistence.jdbc.password", "12345"));
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Prosjekt a = new Prosjekt(prosjektid, navn, beskrivelse);
		
		try {
			tx.begin();
			em.persist(a); //Oppretter en ny rad i databasen
			tx.commit();
			
		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
			return a;
		}
	
    public Prosjekt finnProsjektMedId(int id) {

    	EntityManagerFactory emf = Persistence
    			.createEntityManagerFactory("ansattPersistenceUnit", 
    			Map.of("javax.persistence.jdbc.password", "12345"));
    	
        EntityManager em = emf.createEntityManager();

        Prosjekt prosjekt = null;
        try {
            prosjekt = em.find(Prosjekt.class, id);
        } finally {
            em.close();
        }
        return prosjekt;
    }
}

package no.hvl.dat107.innlevering3;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class AnsattDAO {

	public static Ansatt finnPersonMedId(Integer id) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ansattPersistenceUnit", 
				Map.of("javax.persistence.jdbc.password", "12345"));

        EntityManager em = emf.createEntityManager();

        Ansatt A = null;
        
        try {
            A = em.find(Ansatt.class, id);

        } finally {
            em.close();
        }

        return A;
    }
    
    public static Ansatt finnPersonMedBrukernavn(String brukernavn) {
		
    	EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ansattPersistenceUnit", 
				Map.of("javax.persistence.jdbc.password", "12345"));

        EntityManager em = emf.createEntityManager();

        String queryString = "Select a from Ansatt a Where a.brukernavn = :brukernavn";
        
        try {
            em.getTransaction().begin();
            
            TypedQuery<Ansatt> query = em.createQuery(queryString, Ansatt.class);
            
            query.setParameter("brukernavn", brukernavn);
            
            em.getTransaction().commit();
            
            return query.getSingleResult();
            
        } catch (Exception e) {
        	return null;

        } finally {
            em.close();
        }
    }
    
	public static List<Ansatt> UtlistingAvAnsatte() {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ansattPersistenceUnit", 
				Map.of("javax.persistence.jdbc.password", "12345"));
		
		EntityManager em = emf.createEntityManager();
		
		String queryString = "select a from Ansatt a";
		
		try {
			
			em.getTransaction().begin();
			TypedQuery<Ansatt> query = em.createQuery(queryString, Ansatt.class);
			em.getTransaction().commit();

			return query.getResultList();
			
		} catch (Exception e) {
			return null;

		} finally {
			em.close();
		}
	}
	
	public static Ansatt oppdaterLonn(Integer ansattid, String nyLonn) {
		 
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ansattPersistenceUnit", 
				Map.of("javax.persistence.jdbc.password", "12345"));
		

        EntityManager em = emf.createEntityManager();
	 
        Ansatt ans = null;
        
        try {
        	ans = em.find(Ansatt.class, ansattid);
        	ans.setLonn(nyLonn);
        	
        	em.getTransaction().begin();
        	em.merge(ans);
        	em.getTransaction().commit();
        	
        } catch (Throwable e) {
        	e.printStackTrace();
        	em.getTransaction().rollback();
        } finally {
        	em.close();
        }
      return ans;
	}

	public static Ansatt oppdaterStilling(Integer ansattid, String nyStilling) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ansattPersistenceUnit", 
				Map.of("javax.persistence.jdbc.password", "12345"));

		EntityManager em = emf.createEntityManager();

		Ansatt ans = null;
		
		try {
			ans = em.find(Ansatt.class, ansattid);
			ans.setStilling(nyStilling);
			
			em.getTransaction().begin();
			em.merge(ans);
			em.getTransaction().commit();
		
		} catch (Throwable e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return ans;
	}
 
	public static Ansatt oppdatereStillingOgLonn(Integer ansattid, String nyStilling, String nyLonn) {
	 
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ansattPersistenceUnit", 
				Map.of("javax.persistence.jdbc.password", "12345"));
		

        EntityManager em = emf.createEntityManager();
        
        Ansatt a = null;
        
        try {
        	a= em.find(Ansatt.class, ansattid);
        	
        	a.setStilling(nyStilling);
        	a.setLonn(nyLonn);
        	
        	em.getTransaction().begin();
			em.merge(a);
			em.getTransaction().commit();
			
        } catch (Throwable e) {
		e.printStackTrace();
		em.getTransaction().rollback();
		
        } finally {
		em.close();
        }
        
        return a;
	}
	
	//Dersom programmet skal run'es med generatedValue tas id vekk i parameter og i new Ansatt nedenfor
	public static Ansatt nyAnsatt(Integer id, String brukernavn, String navn, String etternavn,
							String stilling, String lonn, LocalDate ansettelse, Integer avdelingsid) {
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ansattPersistenceUnit", 
				Map.of("javax.persistence.jdbc.password", "12345"));
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Ansatt a = new Ansatt(id, brukernavn, navn, etternavn, stilling, lonn, ansettelse, avdelingsid);

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
	
//    public void registrerProsjektdeltagelse(Ansatt a, Prosjekt p) {
//        
//		EntityManagerFactory emf = Persistence
//				.createEntityManagerFactory("ansattPersistenceUnit", 
//				Map.of("javax.persistence.jdbc.password", "12345"));
//    	
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction tx = em.getTransaction();
//        try {
//            tx.begin();
//            
//            Integer ansattId = a.getId();
//            Integer prosjektId = p.getProsjektid();
//            
//            Ansatt ans = em.find(Ansatt.class, ansattId);
//            Prosjekt pro = em.find(Prosjekt.class, prosjektId);
//            
//            Prosjektdeltagelse pd = new Prosjektdeltagelse(a, p);
//
//            
//            a.leggTilProsjektdeltagelse(pd);
//            p.leggTilProsjektdeltagelse(pd);
//            
//            em.persist(pd);
//            
//            tx.commit();
//        } catch (Throwable e) {
//            e.printStackTrace();
//            if (tx.isActive()) {
//                tx.rollback();
//            }
//        } finally {
//            em.close();
//        }
//        
//    }
 }

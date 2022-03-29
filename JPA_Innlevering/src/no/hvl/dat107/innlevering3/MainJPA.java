package no.hvl.dat107.innlevering3;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import no.hvl.dat107.innlevering3.Prosjekt;
import no.hvl.dat107.innlevering3.Ansatt;

public class MainJPA {

	public static void main(String[] args) {
		
		//Søke etter ansatt med ID
		//System.out.println("Iterator 2 - Hente ut ein ansatt med id");
        //Ansatt A = AnsattDAO.finnPersonMedId(1);
        //A.skrivUt();
        
        //System.out.println();
        
        // Søke etter ansatt med brukernavn
        //System.out.println("Iterator 2 - Hente ut ein ansatt med brukernavn");
        //Ansatt B = AnsattDAO.finnPersonMedBrukernavn("PV");
        //B.skrivUt();
        
        //System.out.println();
        
        // Utlisting av alle ansatte
        //System.out.println("Iterator 2 - Utlisting av alle ansatte");
        //System.out.println(AnsattDAO.UtlistingAvAnsatte());
        
        // Oppdatere stilling og/eller lonn
        //Ansatt A = AnsattDAO.oppdaterLonn(1, "1.000.000kr");
        //A = AnsattDAO.oppdaterStilling(1, "Jr-CEO");
        //Ansatt B = AnsattDAO.oppdatereStillingOgLonn(2, "Head Of Programing", "950.000kr");
        
        // Legge inn ny ansatt
        //AnsattDAO.nyAnsatt(11, "CP", "Chris", "Petter", "Vedlikehold", "600.000kr", LocalDate.of(2013, 4, 25), 3);
        
        // Søke etter avdeling med ID
		//System.out.println("Iterator 3 - Finn avdeling med id");
        //Avdeling C = AvdelingDAO.finnAvdelingMedId(1);
        //C.skrivUt();
        
        //Skriver ut sjef sin informasjon først, deretter dei ansatte i avdelingen
		System.out.println("Utlisting av alle ansatte i gitt avdeling");
        System.out.println(AvdelingDAO.UtlistingAvAnsatteIAvdeling(1));
		
		//Legger til og skriver ut eit prosjekt
		System.out.println(ProsjektDAO.nyProsjekt(4, "Årsoppgaven", "Gjennomgår og lager årsoppgaven"));
		
		
		// Iterator 5 - Registrere Prosjektdeltagelse
//        AnsattDAO ansattDAO = new AnsattDAO();
//        ProsjektDAO prosjektDAO = new ProsjektDAO();
//        
//        Ansatt a2 = ansattDAO.finnPersonMedId(2);
//        Prosjekt p2 = prosjektDAO.finnProsjektMedId(2);
//
//        a2.getDeltagelser();
//		
//        ansattDAO.registrerProsjektdeltagelse(a2, p2);
//        a2.getDeltagelser();

    }

}

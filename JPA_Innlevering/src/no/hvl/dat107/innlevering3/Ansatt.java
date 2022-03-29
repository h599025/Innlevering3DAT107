package no.hvl.dat107.innlevering3;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "Innlevering3")

public class Ansatt {
	
	@Id 	// Primary key annotation. Called @Id no matter what the variable is called
//	@GeneratedValue(strategy = GenerationType.IDENTITY) // Denne er kommentert ut ettersom me ikkje brukte den frå begynnelsen av, og får dermed feil koden
														// ettersom den vil begynne å generere ansattid 1, når me allerede har laget ein med denne id-en
	private Integer id;
	private Integer avdelingsid;
	private String brukernavn, navn, etternavn, stilling, lonn;
	private LocalDate ansettelse;
	
//	@ManyToOne(cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "id", referencedColumnName = "avdelingsid")
//	private Integer ansatt_avdelingsid;
	
//	@OneToOne(mappedBy = "avdelingssjef")
//	private Avdeling SjefFor;
	
//    @OneToMany(mappedBy="ansatt")
//    private List<Prosjektdeltagelse> deltagelser;
	
	public Ansatt() {
		
	}
	
	// Dersom programmet skal run'es med generatedValue tas id vekk i parameter og konstruktør
	public Ansatt(Integer id, String brukernavn, String navn, String etternavn,
								String stilling, String lonn, LocalDate ansettelse, Integer avdelingsid) {
		this.id = id;
		this.brukernavn = brukernavn;
		this.navn = navn;
		this.etternavn = etternavn;
		this.stilling = stilling;
		this.lonn = lonn;
		this.ansettelse = ansettelse;
		this.avdelingsid = avdelingsid;
	}
	
//    public void leggTilProsjektdeltagelse(Prosjektdeltagelse prosjektdeltagelse) {
//        deltagelser.add(prosjektdeltagelse);
//    }
//
//    public void fjernProsjektdeltagelse(Prosjektdeltagelse prosjektdeltagelse) {
//        deltagelser.remove(prosjektdeltagelse);
//    }
	
	public Integer getId() {
		return id;
	}
	
	public String getBrukernavn() {
		return brukernavn;
	}
	
	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}
	
	public String getNavn() {
		return navn;
	}
	
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	public String getEtternavn() {
		return etternavn;
	}
	
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}
	
	public String getStilling() {
		return stilling;
	}
	
	public void setStilling(String stilling) {
		this.stilling = stilling;
	}
	
	public String getLonn() {
		return lonn;
	}
	
	public void setLonn(String lonn) {
		this.lonn = lonn;
	}
	
	public LocalDate getAnsettelse() {
		return ansettelse;
	}
	
	public void setAnsettelse(LocalDate ansettelse) {
		this.ansettelse = ansettelse;
	}
	
	public Integer getAvdelingsid() {
		return avdelingsid;
	}

	public void setAvdelingsid(Integer avdelingsid) {
		this.avdelingsid = avdelingsid;
	}
	
//	public List<Prosjektdeltagelse> getDeltagelser() {
//		return deltagelser;
//	}

	public void skrivUt() {
		System.out.println("Ansattid: " + id + ", Brukernavn: " + brukernavn + ", Navn: " + navn + ", Etternavn: " + etternavn
							+ ", Stilling: " + stilling + ", Lønn: " + lonn + ", Ansettelse: " + ansettelse + ", Avdelingsid: " + avdelingsid);
	}

	@Override
	public String toString() {
		return "\n" + "Ansatt: id = " + id + ", brukernavn = " + brukernavn + ", navn = " + navn + ", etternavn = " + etternavn
				+ ", stilling = " + stilling + ", lonn = " + lonn + ", ansettelse = " + ansettelse + ", avdelingsid = " + avdelingsid;
	}
	
	
	
}

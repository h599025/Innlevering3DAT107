package no.hvl.dat107.innlevering3;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import no.hvl.dat107.innlevering3.Prosjekt;

@Entity
@Table(schema = "Innlevering3")
public class Prosjekt {
	
	@Id 	// Primary key annotation. Called @Id no matter what the variable is called
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer prosjektid;
	private String navn;
	private String beskrivelse;
	
//    @OneToMany(mappedBy="ansatt")
//    private List<Prosjektdeltagelse> deltagelser;
	
	public Prosjekt() {
		
	}
	
	public Prosjekt(Integer prosjektid, String navn, String beskrivelse) {
		this.prosjektid = prosjektid;
		this.navn = navn;
		this.beskrivelse = beskrivelse;
	}
	
//    public void leggTilProsjektdeltagelse(Prosjektdeltagelse prosjektdeltagelse) {
//        deltagelser.add(prosjektdeltagelse);
//    }
//
//    public void fjernProsjektdeltagelse(Prosjektdeltagelse prosjektdeltagelse) {
//        deltagelser.remove(prosjektdeltagelse);
//    }

	public Integer getProsjektid() {
		return prosjektid;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getBeskrivelse() {
		return beskrivelse;
	}

	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}
	
//	public List<Prosjektdeltagelse> getDeltagelser() {
//		return deltagelser;
//	}
	
	public void skrivUt() {
		System.out.println("Prosjektid: " + prosjektid + ", Navn: " + navn + ", Beskrivelse: " + beskrivelse);
	}

	@Override
	public String toString() {
		return "\n" + "Prosjektid: " + prosjektid + ", Navn: " + navn + ", Beskrivelse: " + beskrivelse;
	}
	
	

}

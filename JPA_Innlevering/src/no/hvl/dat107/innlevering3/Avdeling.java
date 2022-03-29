package no.hvl.dat107.innlevering3;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "Innlevering3")
public class Avdeling {

	@Id
//	@OneToMany(mappedBy="ansatt_avdelingsid")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer avdelingsid;
	private String navn;
	
//	@OneToOne(cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "avdelingssjef", referencedColumnName = "avdelingsid")
	private Integer avdelingssjef;
	
	public Avdeling() {
		
	}
	
	//Dersom programmet skal run'es med generatedValue tas avdelingsid vekk i parameter og konstruktør
	public Avdeling(Integer avdelingsid, String navn, Integer avdelingssjef) {
		this.avdelingsid = avdelingsid;
		this.navn = navn;
		this.avdelingssjef = avdelingssjef;
	}

	public Integer getAvdelingsid() {
		return avdelingsid;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public Integer getAvdelingssjef() {
		return avdelingssjef;
	}

	public void setAvdelingssjef(Integer avdelingssjef) {
		this.avdelingssjef = avdelingssjef;
	}
	
	public void skrivUt() {
		System.out.println("Avdelingsid = " + avdelingsid + ", Avdelingsnavn = " + navn + ", Avdelingssjef = " + avdelingssjef);
	}

	@Override
	public String toString() {
		return "\n" + "Avdeling: Avdelingsid = " + avdelingsid + ", navn = " + navn + ", avdelingssjef = " + avdelingssjef;
	}
	
}

package no.hvl.dat107.innlevering3;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(schema = "innlevering3")
@IdClass(ProsjektdeltagelsePK.class)
public class Prosjektdeltagelse {
	
	private Integer timer;
	private String rolle;
    
    @Id
//    @ManyToOne
//    @JoinColumn(name="ansatt_id")
    private Ansatt ansatt;
    
    @Id
//    @ManyToOne
//    @JoinColumn(name="ansatt_id")
    private Prosjekt prosjekt;

    public Prosjektdeltagelse() {}
    
    public Prosjektdeltagelse(Ansatt ansatt, Prosjekt prosjekt) {
        this.ansatt = ansatt;
        this.prosjekt = prosjekt;
        
    }
    
    public void skrivUt(String innrykk) {
        System.out.printf("%sDeltagelse: %s %s, %s, %d timer", innrykk, 
                ansatt.getNavn(), ansatt.getEtternavn(), prosjekt.getNavn(), rolle, timer);
    }
}

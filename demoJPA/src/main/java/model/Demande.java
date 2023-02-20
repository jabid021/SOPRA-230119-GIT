package model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "enfant","jouet" }))
public class Demande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="enfant")
	private Enfant enfant;
	
	@ManyToOne
	@JoinColumn(name="jouet")
	private Jouet jouet;
	
	
	private LocalDate dateDemande;
	
	public Demande() {}

	public Demande(Enfant enfant, Jouet jouet) {
		this.enfant = enfant;
		this.jouet = jouet;
		this.dateDemande = LocalDate.now();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Enfant getEnfant() {
		return enfant;
	}

	public void setEnfant(Enfant enfant) {
		this.enfant = enfant;
	}

	public Jouet getJouet() {
		return jouet;
	}

	public void setJouet(Jouet jouet) {
		this.jouet = jouet;
	}

	public LocalDate getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(LocalDate dateDemande) {
		this.dateDemande = dateDemande;
	}

	@Override
	public String toString() {
		return "Demande [id=" + id + ", enfant=" + enfant + ", jouet=" + jouet + ", dateDemande=" + dateDemande + "]";
	}
	
	
	

}

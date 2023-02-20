package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="activite")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_activite",columnDefinition = "ENUM('Scientifique', 'Tourisme')")
public abstract class Activite {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected boolean guide ;
	@Column(nullable = false,columnDefinition = "DECIMAL(5,2)")
	protected double prix ; 
	protected int duree ;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('Voiture', 'Bateau', 'Helicoptere')")
	protected Vehicule vehicule; 
	
	@ManyToOne
	@JoinColumn(name="biome",nullable = false)
	protected Biome biome; 
	

	@OneToMany(mappedBy = "activite")
	private List<Reservation> reservations;

	public Activite() {}
	
	public Activite(Integer id,boolean guide, double prix, int duree, Biome biome, Vehicule vehicule) {
		this.id=id;
		this.guide = guide;
		this.prix = prix;
		this.duree = duree;
		this.vehicule = vehicule;
		this.biome = biome;
	}

	
	
	public Activite(boolean guide, double prix, int duree, Biome biome, Vehicule vehicule) {
		this.guide = guide;
		this.prix = prix;
		this.duree = duree;
		this.vehicule = vehicule;
		this.biome = biome;
	}

	public boolean isGuide() {
		return guide;
	}

	public void setGuide(boolean guide) {
		this.guide = guide;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Vehicule getVehicule() {
		return vehicule;
	}



	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}



	public Biome getBiome() {
		return biome;
	}



	public void setBiome(Biome biome) {
		this.biome = biome;
	} 

	
}
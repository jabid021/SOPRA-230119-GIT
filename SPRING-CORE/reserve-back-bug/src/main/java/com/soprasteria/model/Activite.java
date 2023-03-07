package com.soprasteria.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="activite")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_activite",columnDefinition = "ENUM('Scientifique', 'Tourisme')")
public abstract class Activite implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;

	protected boolean guide;

	@Column(nullable = false,columnDefinition = "DECIMAL(5,2)")
	protected double prix;

	protected int duree;
	
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('VOITURE', 'BATEAU', 'HELICOPTERE')")
	protected Vehicule vehicule; 
	
	@ManyToOne
	@JoinColumn(name="biome",nullable = false)
	protected Biome biome; 

	@OneToMany(mappedBy = "activite")
	private List<Reservation> reservations;

	protected Activite() { }
	
	protected Activite(Integer id,boolean guide, double prix, int duree, Biome biome, Vehicule vehicule) {
		this.id=id;
		this.guide = guide;
		this.prix = prix;
		this.duree = duree;
		this.vehicule = vehicule;
		this.biome = biome;
	}

	protected Activite(boolean guide, double prix, int duree, Biome biome, Vehicule vehicule) {
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
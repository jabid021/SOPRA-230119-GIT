package com.soprasteria.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name="biome")
public class Biome implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 25,nullable=false)
	private String nom;

	private int superficie;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, columnDefinition ="ENUM('FORET', 'AQUATIQUE', 'MONTAGNE', 'VOLIERE')")
	private Zone zone;
	
	@Version
	private int version;

	@OneToMany(mappedBy = "biome")
	private List<Activite> activites;

	@OneToMany(mappedBy = "biome")
	private List<Espece> especes;
	
	public Biome() { }
	
	public Biome(Integer id,String nom, int superficie, Zone zone) {
		this.id=id;
		this.nom = nom;
		this.superficie = superficie;
		this.zone = zone;
	}
	
	public Biome(String nom, int superficie, Zone zone) {
		this.nom = nom;
		this.superficie = superficie;
		this.zone = zone;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getSuperficie() {
		return superficie;
	}


	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}


	public Zone getZone() {
		return zone;
	}


	public void setZone(Zone zone) {
		this.zone = zone;
	}

	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	

	public List<Activite> getActivites() {
		return activites;
	}

	public void setActivites(List<Activite> activites) {
		this.activites = activites;
	}
	
	

	public List<Espece> getEspeces() {
		return especes;
	}

	public void setEspeces(List<Espece> especes) {
		this.especes = especes;
	}
	
	

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Biome [id=" + id + ", nom=" + nom + ", superficie=" + superficie + ", zone=" + zone + "]";
	}






}
package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="biome")
public class Biome implements Serializable  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 25,nullable=false)
	private String nom;
	private int superficie;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false ,columnDefinition ="ENUM('Foret', 'Aquatique', 'Montagne', 'Voliere')" )
	private Zone zone;
	
	@Version
	private int version;

	

	@OneToMany(mappedBy = "biome")
	private List<Activite> activites;
	

	@OneToMany(mappedBy = "biome")
	private List<Espece> especes;
	
	public Biome() {}
	
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
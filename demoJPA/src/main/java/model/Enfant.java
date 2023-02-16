package model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//Obligatoire
@Entity
@Table(name="kid")
public class Enfant {
	
	//Obligatoire
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_kid")
	private Integer id;
	
	@Column(name="lastname",length = 20 ,nullable = false)
	private String nom;
	@Column(name="firstname", columnDefinition = "VARCHAR(20)" ,nullable = false)
	private String prenom;
	@Column(name="bad",nullable = false)
	private boolean mechant;
	
	@Embedded
	private Adresse adresse;
	
	//Obligatoire
	public Enfant() {}
	
	public Enfant(String nom, String prenom, boolean mechant,Adresse adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.mechant = mechant;
		this.adresse = adresse;
	}
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public boolean isMechant() {
		return mechant;
	}
	public void setMechant(boolean mechant) {
		this.mechant = mechant;
	}



	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Enfant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", mechant=" + mechant + "]";
	}
	
	
	
	
	

}

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jouet")
public class Jouet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String libelle;
	@Column(columnDefinition = "DECIMAL(5,2)")
	private double prix;
	
	@Column(name="categ",columnDefinition = "ENUM('Societe','Peluche','Construction','Autre')")
	@Enumerated(EnumType.STRING)
	private Categorie categorie;
	
	public Jouet() {}
	
	public Jouet(String libelle, double prix, Categorie categorie) {
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Jouet [id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", categorie=" + categorie + "]";
	}

	
	
	
}

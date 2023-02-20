package model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	
	@ManyToOne
	@JoinColumn(name="elf",nullable=false)
	private Lutin createur;
	
	
	@OneToMany(mappedBy = "jouet")
	private Set<Demande> demandes;
	
	public Jouet() {}
	
	public Jouet(String libelle, double prix, Categorie categorie,Lutin createur) {
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;
		this.createur=createur;
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
	
	

	public Lutin getCreateur() {
		return createur;
	}

	public void setCreateur(Lutin createur) {
		this.createur = createur;
	}
	
	

	public Set<Demande> getDemandes() {
		return demandes;
	}

	public void setDemandes(Set<Demande> demandes) {
		this.demandes = demandes;
	}

	@Override
	public String toString() {
		return "Jouet [id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", categorie=" + categorie
				+ ", createur=" + createur + "]";
	}

	
	
	
	
}

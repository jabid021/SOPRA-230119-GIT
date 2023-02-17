package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="dictator")
public class Dictateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String prenom;
	private String nom;
	private boolean cheminee;
	
	
	@OneToOne
	@JoinColumn(name="traineau",nullable=false)
	private Traineau traineau;
	
	public Dictateur() {}
	
	public Dictateur(String prenom, String nom, boolean cheminee,Traineau traineau) {
		this.prenom = prenom;
		this.nom = nom;
		this.cheminee = cheminee;
		this.traineau= traineau;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public boolean isCheminee() {
		return cheminee;
	}
	public void setCheminee(boolean cheminee) {
		this.cheminee = cheminee;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Traineau getTraineau() {
		return traineau;
	}

	public void setTraineau(Traineau traineau) {
		this.traineau = traineau;
	}

	@Override
	public String toString() {
		return "Dictateur [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", cheminee=" + cheminee + ", traineau="
				+ traineau + "]";
	}

	
	
	
	
	
	
}

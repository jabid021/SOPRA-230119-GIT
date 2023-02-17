package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("customer")
public class Client extends Personne {

	private int age;
	@Column(name="birthdate")
	private LocalDate naissance;
	
	@ManyToMany
	@JoinTable(name="achats",joinColumns = @JoinColumn(name="acheteur"),inverseJoinColumns = @JoinColumn(name="produit"))
	private List<Produit> produits = new ArrayList();	
	
	
	public Client() {}

	public Client(String prenom, String nom, Adresse adresse, int age, LocalDate naissance) {
		super(prenom, nom, adresse);
		this.age = age;
		this.naissance = naissance;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getNaissance() {
		return naissance;
	}

	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}
	
	

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", adresse=" + adresse + ", age=" + age
				+ ", naissance=" + naissance + ", produits=" + produits + "]";
	}

	

	
	
}

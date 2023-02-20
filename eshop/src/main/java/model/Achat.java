package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Achat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="date_achat")
	private LocalDate dateAchat;
	
	
	@ManyToOne
	@JoinColumn(name="acheteur")
	private Client client;
	
	@ManyToOne
	@JoinColumn(name="poduit")
	private Produit produit;
	
	
	
	
	public Achat() {
	}




	public Achat(Client client, Produit produit) {
		this.client = client;
		this.produit = produit;
		this.dateAchat=LocalDate.now();
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public LocalDate getDateAchat() {
		return dateAchat;
	}




	public void setDateAchat(LocalDate dateAchat) {
		this.dateAchat = dateAchat;
	}




	public Client getClient() {
		return client;
	}




	public void setClient(Client client) {
		this.client = client;
	}




	public Produit getProduit() {
		return produit;
	}




	public void setProduit(Produit produit) {
		this.produit = produit;
	}




	@Override
	public String toString() {
		return "Achat [id=" + id + ", dateAchat=" + dateAchat + ", client=" + client + ", produit=" + produit + "]";
	}
	
	
	
	
}

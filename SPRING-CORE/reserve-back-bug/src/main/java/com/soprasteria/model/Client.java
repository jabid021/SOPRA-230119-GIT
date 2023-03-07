package com.soprasteria.model;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("client")
public class Client extends Compte {
	@Embedded
	private Adresse adresse;

	@OneToMany(mappedBy = "client")
	private List<Reservation> reservations;
	
	public Client() {

	}
	public Client(Integer id,String login, String password, String nom, String prenom, Adresse adresse) {
		super(id,login, password, nom, prenom);
		this.adresse = adresse;
	}


	public Client(String login, String password, String nom, String prenom, Adresse adresse) {
		super(login, password, nom, prenom);
		this.adresse = adresse;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + ", adresse=" + adresse + "]";
	}



}

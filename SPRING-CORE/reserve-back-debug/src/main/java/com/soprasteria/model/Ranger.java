package com.soprasteria.model;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("ranger")
public class Ranger extends Compte {
	private int anciennete;
	
	@OneToMany(mappedBy = "ranger")
	private List<Reservation> reservations;
	
	public Ranger() {

	}

	public Ranger(Integer id,String login, String password, String nom, String prenom, int anciennete) {
		super(id,login, password, nom, prenom);
		this.anciennete = anciennete;
	}

	public Ranger(String login, String password, String nom, String prenom, int anciennete) {
		super(login, password, nom, prenom);
		this.anciennete = anciennete;
	}

	public int getAnciennete() {
		return anciennete;
	}

	public void setAnciennete(int anciennete) {
		this.anciennete = anciennete;
	}
	
	

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return "Ranger [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + ", anciennete=" + anciennete + "]";
	}






}
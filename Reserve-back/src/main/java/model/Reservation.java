package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {
	private Integer id;
	private int effectif;
	private double prix;
	private LocalDate jour;
	private LocalTime heure;
	private Client client;
	private Ranger ranger;
	private Activite activite;

	public Reservation(Integer id,int effectif, double prix, LocalDate jour, LocalTime heure, Client client, Activite activite) {
		this.id=id;
		this.effectif = effectif;
		this.prix = prix;
		this.jour = jour;
		this.heure = heure;
		this.client = client;
		this.activite = activite;
	}
	
	public Reservation(int effectif, double prix, LocalDate jour, LocalTime heure, Client client, Activite activite) {
		this.effectif = effectif;
		this.prix = prix;
		this.jour = jour;
		this.heure = heure;
		this.client = client;
		this.activite = activite;
	}

	public int getEffectif() {
		return effectif;
	}

	public void setEffectif(int effectif) {
		this.effectif = effectif;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public LocalDate getJour() {
		return jour;
	}

	public void setJour(LocalDate jour) {
		this.jour = jour;
	}

	public LocalTime getHeure() {
		return heure;
	}

	public void setHeure(LocalTime heure) {
		this.heure = heure;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Ranger getRanger() {
		return ranger;
	}

	public void setRanger(Ranger ranger) {
		this.ranger = ranger;
	}

	public Activite getActivite() {
		return activite;
	}

	public void setActivite(Activite activite) {
		this.activite = activite;
	}

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", effectif=" + effectif + ", prix=" + prix + ", jour=" + jour + ", heure="
				+ heure + ", client=" + client + ", ranger=" + ranger + ", activite=" + activite + "]";
	}

	

}
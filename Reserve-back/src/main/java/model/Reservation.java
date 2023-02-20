package model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int effectif;
	@Column(nullable = false,columnDefinition = "DECIMAL(5,2)")
	private double prix;
	private LocalDate jour;
	private LocalTime heure;
	
	@ManyToOne
	@JoinColumn(name="client",nullable = false)
	private Client client;
	@ManyToOne
	@JoinColumn(name="ranger")
	private Ranger ranger;
	@ManyToOne
	@JoinColumn(name="activite",nullable = false)
	private Activite activite;

	public Reservation() {
	}
	
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
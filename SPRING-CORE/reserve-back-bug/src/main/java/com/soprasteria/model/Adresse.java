package com.soprasteria.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Adresse implements Serializable {
	@Column(length=10)
	private String numero;

	@Column(length=40)
	private String voie;

	@Column(length=50)
	private String ville;

	@Column(length=15)
	private String cp;

	@Column(length=30)
	private String pays;

	public Adresse() { }

	public Adresse(String numero, String voie, String ville, String cp, String pays) {
		this.numero = numero;
		this.voie = voie;
		this.ville = ville;
		this.cp = cp;
		this.pays = pays;
	}

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	@Override
	public String toString() {
		return "Adresse [numero=" + numero + ", voie=" + voie + ", ville=" + ville + ", cp=" + cp + ", pays=" + pays
				+ "]";
	}
}
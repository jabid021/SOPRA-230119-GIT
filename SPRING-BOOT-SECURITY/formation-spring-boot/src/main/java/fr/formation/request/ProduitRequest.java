package fr.formation.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class ProduitRequest {
	@NotBlank(message = "Le libellé doit être saisi")
	private String libelle;

	@Positive(message = "Le prix est forcément positif.")
	private double prix;

	private int fournisseurId;

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

	public int getFournisseurId() {
		return fournisseurId;
	}

	public void setFournisseurId(int fournisseurId) {
		this.fournisseurId = fournisseurId;
	}
}

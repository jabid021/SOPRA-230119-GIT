package fr.formation.request;

import jakarta.validation.constraints.NotBlank;

public class FournisseurRequest {
	@NotBlank
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}

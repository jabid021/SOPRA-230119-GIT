package fr.formation.response;

public class ProduitResponse {
	private int id;
	private String libelle;
	private double prix;
	private int fournisseurId;
	private String fournisseurNom;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getFournisseurNom() {
		return fournisseurNom;
	}

	public void setFournisseurNom(String fournisseurNom) {
		this.fournisseurNom = fournisseurNom;
	}
}

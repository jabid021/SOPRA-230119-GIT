package fr.formation.response;

public class FournisseurResponse {
	private int id;
	private String nom;
	private int nbProduits;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNbProduits() {
		return nbProduits;
	}

	public void setNbProduits(int nbProduits) {
		this.nbProduits = nbProduits;
	}
}

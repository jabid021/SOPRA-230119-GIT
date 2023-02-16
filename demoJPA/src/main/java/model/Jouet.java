package model;

public class Jouet {

	private String libelle;
	private double prix;
	private Categorie categorie;
	
	public Jouet(String libelle, double prix, Categorie categorie) {
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;
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

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Jouet [libelle=" + libelle + ", prix=" + prix + ", categorie=" + categorie + "]";
	}
	
	
}

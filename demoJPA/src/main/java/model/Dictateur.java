package model;

public class Dictateur {

	private String prenom;
	private String nom;
	private boolean cheminee;
	public Dictateur(String prenom, String nom, boolean cheminee) {
		this.prenom = prenom;
		this.nom = nom;
		this.cheminee = cheminee;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public boolean isCheminee() {
		return cheminee;
	}
	public void setCheminee(boolean cheminee) {
		this.cheminee = cheminee;
	}
	@Override
	public String toString() {
		return "Dictateur [prenom=" + prenom + ", nom=" + nom + ", cheminee=" + cheminee + "]";
	}
	
	
	
	
}

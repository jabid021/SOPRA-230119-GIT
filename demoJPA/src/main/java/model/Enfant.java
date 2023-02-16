package model;

public class Enfant {
	
	private String nom;
	private String prenom;
	private boolean mechant;
	
	public Enfant(String nom, String prenom, boolean mechant) {
		this.nom = nom;
		this.prenom = prenom;
		this.mechant = mechant;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public boolean isMechant() {
		return mechant;
	}
	public void setMechant(boolean mechant) {
		this.mechant = mechant;
	}
	
	@Override
	public String toString() {
		return "Enfant [nom=" + nom + ", prenom=" + prenom + ", mechant=" + mechant + "]";
	}
	
	
	
	

}

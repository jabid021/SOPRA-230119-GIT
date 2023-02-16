package model;

public class Esclave {

	private String prenom;

	public Esclave(String prenom) {
		this.prenom = prenom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Esclave [prenom=" + prenom + "]";
	}
	
	
	
	
}

package model.tablePerClass;

public class Kayak extends Vehicule {

	private String couleur;
	
	public Kayak() {}

	
	public Kayak(int nbRoue, String couleur) {
		super(nbRoue);
		this.couleur = couleur;
	}


	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}


	@Override
	public String toString() {
		return "Kayak [couleur=" + couleur + "]";
	}
	
	
}

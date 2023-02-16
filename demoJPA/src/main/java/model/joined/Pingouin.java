package model.joined;

public class Pingouin extends Animal{

	private String couleur;

	public Pingouin() {}
	
	public Pingouin(String nom, String couleur) {
		super(nom);
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
		return "Pingouin [id=" + id + ", nom=" + nom + ", couleur=" + couleur + "]";
	}
	
	
	
}

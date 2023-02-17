package model.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;

//@Entity
@Table(name="pingouin")
public class Pingouin extends Animal{

	@Column(nullable = false)
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

package model;

import javax.persistence.Entity;

@Entity
public class Animal extends Espece {

	private int dangerosite;
	public Animal() {
	}

	public Animal(Integer id,String nom, int effectif, int indiceProtection, int dangerosite, Biome biome) {
		super(id,nom, effectif, indiceProtection, biome);

		this.dangerosite = dangerosite;
	}


	public Animal(String nom, int effectif, int indiceProtection, int dangerosite, Biome biome) {
		super(nom, effectif, indiceProtection, biome);

		this.dangerosite = dangerosite;
	}

	public int getDangerosite() {
		return dangerosite;
	}

	public void setDangerosite(int dangerosite) {
		this.dangerosite = dangerosite;
	}


	@Override
	public String toString() {
		return "Animal [id=" + id + ", nom=" + nom + ", effectif=" + effectif + ", indiceProtection=" + indiceProtection
				+ ", biome=" + biome + ", dangerosite=" + dangerosite + "]";
	}




}
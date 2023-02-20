package model;

import javax.persistence.Entity;

@Entity
public class Vegetal extends Espece {

	public Vegetal() {
	}
	public Vegetal(Integer id,String nom, int effectif, int indiceProtection, Biome biome) {
		super(id,nom, effectif, indiceProtection, biome);
	}


	public Vegetal(String nom, int effectif, int indiceProtection, Biome biome) {
		super(nom, effectif, indiceProtection, biome);
	}
	@Override
	public String toString() {
		return "Vegetal [id=" + id + ", nom=" + nom + ", effectif=" + effectif + ", indiceProtection="
				+ indiceProtection + ", biome=" + biome + "]";
	}



}
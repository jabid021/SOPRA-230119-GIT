package model;

import java.io.Serializable;

public abstract class Espece implements Serializable  {

	protected Integer id;
	protected String nom;
	protected int effectif;
	protected transient int indiceProtection;
	protected Biome biome;

	public Espece(Integer id,String nom, int effectif, int indiceProtection, Biome biome) {
		this.id=id;
		this.nom = nom;
		this.effectif = effectif;
		this.indiceProtection = indiceProtection;
		this.biome = biome;
	}

	public Espece(String nom, int effectif, int indiceProtection, Biome biome) {
		this.nom = nom;
		this.effectif = effectif;
		this.indiceProtection = indiceProtection;
		this.biome = biome;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getEffectif() {
		return effectif;
	}
	public void setEffectif(int effectif) {
		this.effectif = effectif;
	}
	public int getIndiceProtection() {
		return indiceProtection;
	}
	public void setIndiceProtection(int indiceProtection) {
		this.indiceProtection = indiceProtection;
	}
	public Biome getBiome() {
		return biome;
	}
	public void setBiome(Biome biome) {
		this.biome = biome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
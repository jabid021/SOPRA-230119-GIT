package com.soprasteria.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="espece")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_espece",columnDefinition = "enum('Vegetal', 'Animal')")
public abstract class Espece implements Serializable  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	@Column(length = 20,nullable = false)
	protected String nom;
	protected int effectif;
	
	@Column(name="indice_protection",nullable = false)
	protected int indiceProtection;
	
	@ManyToOne
	@JoinColumn(name="biome",nullable = false)
	protected Biome biome;
	
	protected Espece() { }

	protected Espece(Integer id,String nom, int effectif, int indiceProtection, Biome biome) {
		this.id=id;
		this.nom = nom;
		this.effectif = effectif;
		this.indiceProtection = indiceProtection;
		this.biome = biome;
	}

	protected Espece(String nom, int effectif, int indiceProtection, Biome biome) {
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
package com.soprasteria.model;

import jakarta.persistence.Entity;

@Entity
public class Tourisme extends Activite {
	public Tourisme() { }

	public Tourisme(Integer id, boolean guide, double prix, int duree, Biome biome, Vehicule vehicule) {
		super(id,guide, prix, duree, biome, vehicule);
	}
	
	public Tourisme(boolean guide, double prix, int duree, Biome biome, Vehicule vehicule) {
		super(guide, prix, duree, biome, vehicule);
	}

	@Override
	public String toString() {
		return "Tourisme [id=" + id + ", guide=" + guide + ", prix=" + prix + ", duree=" + duree + ", vehicule="
				+ vehicule + ", biome=" + biome + "]";
	}
}
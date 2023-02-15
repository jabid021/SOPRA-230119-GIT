package model;

import java.io.Serializable;

public class Biome implements Serializable  {
	
	private Integer id;
	private String nom;
	private int superficie;
	private Zone zone;

	
	public Biome(Integer id,String nom, int superficie, Zone zone) {
		this.id=id;
		this.nom = nom;
		this.superficie = superficie;
		this.zone = zone;
	}
	
	public Biome(String nom, int superficie, Zone zone) {
		this.nom = nom;
		this.superficie = superficie;
		this.zone = zone;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getSuperficie() {
		return superficie;
	}


	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}


	public Zone getZone() {
		return zone;
	}


	public void setZone(Zone zone) {
		this.zone = zone;
	}

	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Biome [id=" + id + ", nom=" + nom + ", superficie=" + superficie + ", zone=" + zone + "]";
	}






}
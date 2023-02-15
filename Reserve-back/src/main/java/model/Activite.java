package model;

public abstract class Activite {
	protected Integer id;
	protected boolean guide ;
	protected double prix ; 
	protected int duree ;
	protected Vehicule vehicule; 
	protected Biome biome; 

	
	public Activite(Integer id,boolean guide, double prix, int duree, Biome biome, Vehicule vehicule) {
		this.id=id;
		this.guide = guide;
		this.prix = prix;
		this.duree = duree;
		this.vehicule = vehicule;
		this.biome = biome;
	}

	
	
	public Activite(boolean guide, double prix, int duree, Biome biome, Vehicule vehicule) {
		this.guide = guide;
		this.prix = prix;
		this.duree = duree;
		this.vehicule = vehicule;
		this.biome = biome;
	}

	public boolean isGuide() {
		return guide;
	}

	public void setGuide(boolean guide) {
		this.guide = guide;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Vehicule getVehicule() {
		return vehicule;
	}



	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}



	public Biome getBiome() {
		return biome;
	}



	public void setBiome(Biome biome) {
		this.biome = biome;
	} 

	
}
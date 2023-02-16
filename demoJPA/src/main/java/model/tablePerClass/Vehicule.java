package model.tablePerClass;

public abstract class Vehicule {

	protected Integer id;
	protected int nbRoue;

	public Vehicule() {
	}
	
	public Vehicule(int nbRoue) {
		this.nbRoue = nbRoue;
	}

	public int getNbRoue() {
		return nbRoue;
	}

	public void setNbRoue(int nbRoue) {
		this.nbRoue = nbRoue;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}

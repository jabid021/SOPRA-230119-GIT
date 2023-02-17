package model.tablePerClass;

import javax.persistence.Entity;

//@Entity
public class Voiture extends Vehicule{

	private String marque;
	
	public Voiture() {}
	
	public Voiture(int nbRoue, String marque) {
		super(nbRoue);
		this.marque = marque;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	@Override
	public String toString() {
		return "Voiture [id=" + id + ", nbRoue=" + nbRoue + ", marque=" + marque + "]";
	}

	
}

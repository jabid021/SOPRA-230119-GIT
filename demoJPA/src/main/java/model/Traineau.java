package model;

public class Traineau {

	private int autonomie;
	private	int clochettes;
	private double poids;
	
	public Traineau(int autonomie, int clochettes, double poids) {
		this.autonomie = autonomie;
		this.clochettes = clochettes;
		this.poids = poids;
	}

	public int getAutonomie() {
		return autonomie;
	}

	public void setAutonomie(int autonomie) {
		this.autonomie = autonomie;
	}

	public int getClochettes() {
		return clochettes;
	}

	public void setClochettes(int clochettes) {
		this.clochettes = clochettes;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	@Override
	public String toString() {
		return "Traineau [autonomie=" + autonomie + ", clochettes=" + clochettes + ", poids=" + poids + "]";
	}
	
	
	
	
}

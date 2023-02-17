package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="traineau")
public class Traineau {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int autonomie;
	private	int clochettes;
	private double poids;
	
	
	
	public Traineau() {
	}
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

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Traineau [id=" + id + ", autonomie=" + autonomie + ", clochettes=" + clochettes + ", poids=" + poids
				+ "]";
	}
	
	
	
	
	
	
}

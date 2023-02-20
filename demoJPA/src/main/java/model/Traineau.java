package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	@OneToOne(mappedBy = "traineau")
	private Dictateur conducteur;
	
	
	@OneToMany(mappedBy="traineau")
	private List<Renne> attelage;
	
	
	
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
	
	
	public Dictateur getConducteur() {
		return conducteur;
	}

	public void setConducteur(Dictateur conducteur) {
		this.conducteur = conducteur;
	}
	

	public List<Renne> getAttelage() {
		return attelage;
	}

	public void setAttelage(List<Renne> attelage) {
		this.attelage = attelage;
	}

	@Override
	public String toString() {
		return "Traineau [id=" + id + ", autonomie=" + autonomie + ", clochettes=" + clochettes + ", poids=" + poids
				+ "]";
	}

	
	
	
	
	
	
}

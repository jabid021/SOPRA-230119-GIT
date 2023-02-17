package model.tablePerClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

//@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "vehiculeJpa",sequenceName = "seq_vehicule")
public abstract class Vehicule {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "vehiculeJpa")
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

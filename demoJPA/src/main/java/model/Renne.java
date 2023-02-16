package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("reindeer")
public class Renne extends Esclave{

	
	public Renne() {	
	}

	public Renne(String prenom) {
		super(prenom);
	}

	@Override
	public String toString() {
		return "Renne [id=" + id + ", prenom=" + prenom + "]";
	}

	
}

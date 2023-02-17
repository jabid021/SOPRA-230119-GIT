package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("reindeer")
public class Renne extends Esclave{
	
	@ManyToOne
	private Traineau traineau;
	

	
	public Renne() {	
	}

	public Renne(String prenom,Traineau traineau) {
		super(prenom);
		this.traineau=traineau;
	}

	@Override
	public String toString() {
		return "Renne [id=" + id + ", prenom=" + prenom + ", traineau=" + traineau + "]";
	}

	

	
}

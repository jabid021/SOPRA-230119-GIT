package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
@Entity
@DiscriminatorValue("Medecin")
public class Medecin extends Compte {

	private transient int salle;
	
	@OneToMany(mappedBy="medecin")
	private List<Visite> consultations = new ArrayList();
	
	public Medecin() {
	}
	public Medecin(Integer id, String login, String password) {
		super(id, login, password);
	}

	public int getSalle() {
		return salle;
	}

	public void setSalle(int salle) {
		this.salle = salle;
	}

	public List<Visite> getConsultations() {
		return consultations;
	}

	public void setConsultations(List<Visite> consultations) {
		this.consultations = consultations;
	}

	@Override
	public String toString() {
		return "Medecin [id=" + id + ", login=" + login + ", password=" + password + ", salle=" + salle + "]";
	}

	
}

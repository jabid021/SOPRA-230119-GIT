package model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("elf")
public class Lutin extends Esclave{

	
	private boolean chapeau;
	
	@OneToMany(mappedBy="createur")
	private List<Jouet> jouets;
	
	public Lutin() {}
	
	public Lutin(String prenom, boolean chapeau) {
		super(prenom);
		this.chapeau = chapeau;
	}

	public boolean isChapeau() {
		return chapeau;
	}

	public void setChapeau(boolean chapeau) {
		this.chapeau = chapeau;
	}
	

	public List<Jouet> getJouets() {
		return jouets;
	}

	public void setJouets(List<Jouet> jouets) {
		this.jouets = jouets;
	}

	@Override
	public String toString() {
		return "Lutin [id=" + id + ", prenom=" + prenom + ", chapeau=" + chapeau + "]";
	}
	
	
	
	
	
}

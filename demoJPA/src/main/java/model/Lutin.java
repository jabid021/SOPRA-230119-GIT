package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("elf")
public class Lutin extends Esclave{

	
	private boolean chapeau;
	
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

	@Override
	public String toString() {
		return "Lutin [id=" + id + ", prenom=" + prenom + ", chapeau=" + chapeau + "]";
	}
	
	
	
	
	
}

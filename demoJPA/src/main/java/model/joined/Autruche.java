package model.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//@Entity
@Table(name="autruche")
@PrimaryKeyJoinColumn(name="id_autruche")
public class Autruche extends Animal {


	
	private int cou;

	public Autruche() {}
	
	public Autruche(String nom, int cou) {
		super(nom);
		this.cou = cou;
	}

	public int getCou() {
		return cou;
	}

	public void setCou(int cou) {
		this.cou = cou;
	}

	@Override
	public String toString() {
		return "Autruche [id=" + id + ", nom=" + nom + ", cou=" + cou + "]";
	}

	
	
}

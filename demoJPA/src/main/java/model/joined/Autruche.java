package model.joined;

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

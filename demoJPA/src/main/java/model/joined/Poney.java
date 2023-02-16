package model.joined;

public class Poney  extends Animal{

	private int sabot;
	public Poney() {}
	
	public Poney(String nom, int sabot) {
		super(nom);
		this.sabot = sabot;
	}

	public int getSabot() {
		return sabot;
	}

	public void setSabot(int sabot) {
		this.sabot = sabot;
	}

	@Override
	public String toString() {
		return "Poney [id=" + id + ", nom=" + nom + ", sabot=" + sabot + "]";
	}


}

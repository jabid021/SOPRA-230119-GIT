package model;

public class Ranger extends Compte {
	private int anciennete;

	
	public Ranger(Integer id,String login, String password, String nom, String prenom, int anciennete) {
		super(id,login, password, nom, prenom);
		this.anciennete = anciennete;
	}
	
	public Ranger(String login, String password, String nom, String prenom, int anciennete) {
		super(login, password, nom, prenom);
		this.anciennete = anciennete;
	}

	public int getAnciennete() {
		return anciennete;
	}

	public void setAnciennete(int anciennete) {
		this.anciennete = anciennete;
	}

	@Override
	public String toString() {
		return "Ranger [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + ", anciennete=" + anciennete + "]";
	}

	




}
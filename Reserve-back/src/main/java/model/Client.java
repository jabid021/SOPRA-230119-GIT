package model;

public class Client extends Compte{
	private Adresse adresse;

	public Client(Integer id,String login, String password, String nom, String prenom, Adresse adresse) {
		super(id,login, password, nom, prenom);
		this.adresse = adresse;
	}

	
	public Client(String login, String password, String nom, String prenom, Adresse adresse) {
		super(login, password, nom, prenom);
		this.adresse = adresse;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	@Override
	public String toString() {
		return "Client [id=" + id + ", login=" + login + ", password=" + password + ", nom=" + nom + ", prenom="
				+ prenom + ", adresse=" + adresse + "]";
	}

	
	
}

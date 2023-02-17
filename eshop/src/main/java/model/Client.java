package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("customer")
public class Client extends Personne {

	private int age;
	@Column(name="birthdate")
	private LocalDate naissance;
	
	public Client() {}

	public Client(String prenom, String nom, Adresse adresse, int age, LocalDate naissance) {
		super(prenom, nom, adresse);
		this.age = age;
		this.naissance = naissance;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getNaissance() {
		return naissance;
	}

	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", adresse=" + adresse + ", age=" + age
				+ ", naissance=" + naissance + "]";
	}
	
}

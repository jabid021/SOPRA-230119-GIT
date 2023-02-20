package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="compte")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_compte",columnDefinition = "ENUM('admin', 'ranger', 'client')")
public abstract class Compte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	@Column(length = 25,nullable = false)
	protected String login;
	@Column(length = 125,nullable = false)
	protected String password;
	@Column(length = 50,nullable = false)
	protected String nom;
	@Column(length = 50,nullable = false)
	protected String prenom;


	public Compte() {

	}
	public Compte(Integer id,String login, String password, String nom, String prenom) {
		this.id=id;
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Compte(String login, String password, String nom, String prenom) {
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


}
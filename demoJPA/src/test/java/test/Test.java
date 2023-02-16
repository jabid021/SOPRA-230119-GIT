package test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Adresse;
import model.Categorie;
import model.Dictateur;
import model.Enfant;
import model.Esclave;
import model.Jouet;
import model.Traineau;

public class Test {

	public static void main(String[] args) {
	
		
		Adresse a1 = new Adresse("1","rue de paris","75001","Marseille");
		Adresse a2 = new Adresse("2","rue de paris","75001","Marseille");
		Enfant enf1 = new Enfant("Ribeiro","Mathias",false);
		Enfant enf2 = new Enfant("Feroldi","Thomas",true);
		Jouet jouet1 = new Jouet("Velociraptor",500.50,Categorie.Peluche);
		Jouet jouet2 = new Jouet("Pomme",0.50,Categorie.Autre);
		
		Dictateur boss = new Dictateur("Payr", "Noel", true);
		
		Esclave esc1 = new Esclave("Jordan");
		Esclave esc2 = new Esclave("Eric");
		
		Traineau traineau = new Traineau(24,100,500000);
		
		
	//demoJpa correspond au nom de notre persistence-unit dans le fichier de conf persistence.xml
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoJPA");
	

	
	
	
	
	
	
	
	
	
	
	
	
	emf.close();

	}

}

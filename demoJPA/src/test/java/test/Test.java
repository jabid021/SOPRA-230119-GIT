package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Adresse;
import model.Categorie;
import model.Dictateur;
import model.Enfant;
import model.Esclave;
import model.Jouet;
import model.Lutin;
import model.Renne;
import model.Traineau;
import model.joined.Animal;
import model.joined.Autruche;
import model.joined.Pingouin;
import model.joined.Poney;
import model.tablePerClass.Kayak;
import model.tablePerClass.Vehicule;
import model.tablePerClass.Voiture;

public class Test {

	public static void main(String[] args) {
	
		
		Adresse a1 = new Adresse("1","rue de paris","75001","Marseille");
		Adresse a2 = new Adresse("2","rue de paris","75001","Marseille");
		
		Lutin esc1 = new Lutin("Jordan",false);
		Lutin esc2 = new Lutin("Eric",true);
		
		Enfant enf1 = new Enfant("Ribeiro","Mathias",false,a1);
		Enfant enf2 = new Enfant("Feroldi","Thomas",true,a2);
		Jouet jouet1 = new Jouet("Velociraptor",500.50,Categorie.Peluche,esc1);
		Jouet jouet2 = new Jouet("Pomme",0.50,Categorie.Autre,esc2);
		
		enf1.getDemandes().add(jouet1);
		enf2.getDemandes().add(jouet2); 
		
		Traineau traineau = new Traineau(24,100,500000);
		
		Dictateur boss = new Dictateur("Payr", "Noel", true,traineau);
		
		
		
		
		Esclave esc3 = new Renne("Rudolph",traineau);
		
		
		
		
		Autruche autruche = new Autruche("autruche",100);
		Pingouin pingouin = new Pingouin("pingu","noir et blanc");
		Poney poney = new Poney("my little",4);
		
		
		Kayak k = new Kayak(0,"jaune");
		Voiture v = new Voiture(4,"Fiat panda");
		
		
		
		
		
		
	//demoJpa correspond au nom de notre persistence-unit dans le fichier de conf persistence.xml
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoJPA");
	

	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
	
	
	em.persist(esc1);
	em.persist(esc2);
	em.persist(esc3);
	
	em.persist(jouet1);
	em.persist(jouet2);
	
	
	em.persist(enf1);
	em.persist(enf2);
	
	em.persist(traineau);
	
	em.persist(boss);

	
	

	em.getTransaction().commit();
	
	em.close();

	
	em = emf.createEntityManager();
	
	System.out.println(em.find(Dictateur.class, 1));
	em.close();
	
	emf.close();

	}

}

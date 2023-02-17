package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Adresse;
import model.Client;
import model.Fournisseur;
import model.Personne;
import model.Produit;

public class Test {

	public static void main(String[] args) {
		
		Adresse a1 = new Adresse("1","chez moi","ma ville","0000");
		Adresse a2 = new Adresse("6","rue rougemont","Paris","75009");
		Fournisseur f1 = new Fournisseur("Abid","Charly",a2,"AJC"); 
	
		Client c1 = new Client("Jordan","Abid",a1,29,LocalDate.parse("1993-05-01"));
		Produit p1 = new Produit("Formation SQL",1500);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshopUnit");
		

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(c1);
		em.persist(p1);
		em.persist(f1);

		em.getTransaction().commit();
		
		em.close();

		em = emf.createEntityManager();
		
		System.out.println(em.find(Personne.class, 1));
		em.close();
		
		
		emf.close();
	}

}

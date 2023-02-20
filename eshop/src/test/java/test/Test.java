package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Achat;
import model.Adresse;
import model.Client;
import model.Fournisseur;
import model.Produit;

public class Test {

	public static void main(String[] args) {
		
		Adresse a1 = new Adresse("1","chez moi","ma ville","0000");
		Adresse a2 = new Adresse("6","rue rougemont","Paris","75009");
		Fournisseur f1 = new Fournisseur("Abid","Charly",a2,"AJC"); 
	
		Client c1 = new Client("Jordan","Abid",a1,29,LocalDate.parse("1993-05-01"));
		Produit p1 = new Produit("Formation SQL",1500,f1);
		Produit p2 = new Produit("Formation Java",2500,f1);
		
		
		Achat ac1 = new Achat(c1,p1);
		Achat ac2 = new Achat(c1,p2);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshopUnit");
		

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(f1);
		
		em.persist(p1);
		em.persist(p2);

		em.persist(c1);

		em.persist(ac1);
		em.persist(ac2);
		
		
		em.getTransaction().commit();
		
		em.close();

		em = emf.createEntityManager();
		
	
		em.close();
		
		emf.close();
	}

}

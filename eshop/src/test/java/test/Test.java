package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Personne;
import model.Produit;

public class Test {

	public static void main(String[] args) {
		
		Personne c1 = new Personne("Jordan","Abid");
		Produit p1 = new Produit("Formation SQL",1500);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshopUnit");
		

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(c1);
		em.persist(p1);

		em.getTransaction().commit();
		
		em.close();

		
		emf.close();
	}

}

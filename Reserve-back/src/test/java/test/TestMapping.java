package test;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Compte;

public class TestMapping {

	

	public static String saisieString(String msg) 
	{
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		return monScanner.nextLine();
	}

	public static int saisieInt(String msg) 
	{
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		return monScanner.nextInt();
	}

	public static double saisieDouble(String msg) 
	{
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		return monScanner.nextDouble();
	}

	public static boolean saisieBoolean(String msg) 
	{
		Scanner monScanner = new Scanner(System.in);
		System.out.println(msg);
		return monScanner.nextBoolean();
	}
	
	public static void main(String[] args) {
		
		
		String login = saisieString("Saisir login");
		String password = saisieString("Saisis password");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("reserve");
	
		
		
		
		
		EntityManager em = emf.createEntityManager();
		
		Query q =  em.createQuery("from Compte c where c.login=:login and c.password=:password");
		q.setParameter("login", login);
		q.setParameter("password", password);
		
		//Compte connected = (Compte) em.createQuery("from Compte c where c.login=:login and c.password=:password").setParameter("login", login).setParameter("password", password).getSingleResult();
	
		
		//Compte connected = (Compte) q.getSingleResult();
		
		System.out.println(em.createQuery("from Biome").getResultList());

		System.out.println(em.createQuery("from Activite").getResultList());
		
		System.out.println(em.createQuery("from Tourisme").getResultList());
		
		em.close();
		
		
	
		emf.close();
	}

}

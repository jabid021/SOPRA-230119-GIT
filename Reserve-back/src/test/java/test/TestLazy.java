package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import context.Singleton;
import model.Activite;
import model.Biome;
import model.Espece;

public class TestLazy {

	//Acces aux especes APRES le em.close() ❌
	//Impossibe de faire des filtres sur les especes ❌
	public static List<Biome> showLazy()
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Query q = em.createQuery("from Biome b");
		List<Biome> biomes = q.getResultList();

		em.close();
		return biomes;
	}


	//Acces aux especes APRES le em.close() ❌
	//Possibe de faire des filtres sur les especes ✔
	public static List<Biome> showFilter()
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Query q = em.createQuery("SELECT b from Biome b join b.especes e  where e.nom like '%o%'");
		List<Biome> biomes = q.getResultList();

		em.close();
		return biomes;
	}



	//Acces aux especes APRES le em.close() ❌
	//Possibe de faire des filtres sur les especes ✔
	//Les biomes n'ayant pas d'espece ne sont pas return ❌ 
	//Les biomes ayant plusieurs especes sont return en doublons ❌
	public static List<Biome> showJoin()
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Query q = em.createQuery("SELECT b from Biome b join b.especes e ");
		List<Biome> biomes = q.getResultList();

		em.close();
		return biomes;
	}


	//Acces aux especes APRES le em.close() ❌
	//Possibe de faire des filtres sur les especes ✔
	//Les biomes n'ayant pas d'espece ne sont pas return ✔
	//Les biomes ayant plusieurs especes sont return en doublons ❌
	public static List<Biome> showLeftJoin()
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Query q = em.createQuery("SELECT b from Biome b left join b.especes e ");
		List<Biome> biomes = q.getResultList();

		em.close();
		return biomes;
	}



	//Acces aux especes APRES le em.close() ❌
	//Possibe de faire des filtres sur les especes ✔
	//Les biomes n'ayant pas d'espece ne sont pas return ❌ 
	//Les biomes ayant plusieurs especes sont return en doublons ✔
	public static List<Biome> showDistinctJoin()
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Query q = em.createQuery("SELECT DISTINCT b from Biome b join b.especes e ");
		List<Biome> biomes = q.getResultList();

		em.close();
		return biomes;
	}

	//Acces aux especes APRES le em.close() ❌
	//Possibe de faire des filtres sur les especes ✔
	//Les biomes n'ayant pas d'espece ne sont pas return ✔ 
	//Les biomes ayant plusieurs especes sont return en doublons ✔
	public static List<Biome> showDistinctLeftJoin()
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Query q = em.createQuery("SELECT DISTINCT b from Biome b left join b.especes e ");
		List<Biome> biomes = q.getResultList();

		em.close();
		return biomes;
	}



	//Acces aux especes APRES le em.close() ✔
	//Possibe de faire des filtres sur les especes ✔
	//Les biomes n'ayant pas d'espece ne sont pas return ❌ 
	//Les biomes ayant plusieurs especes sont return en doublons ❌
	public static List<Biome> showJoinAfterClose()
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Query q = em.createQuery("SELECT b from Biome b join fetch b.especes e ");
		List<Biome> biomes = q.getResultList();

		em.close();
		return biomes;
	}



	//Acces aux especes APRES le em.close() ✔
	//Possibe de faire des filtres sur les especes ✔
	//Les biomes n'ayant pas d'espece ne sont pas return ✔ 
	//Les biomes ayant plusieurs especes sont return en doublons ❌
	public static List<Biome> showLeftJoinAfterClose()
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Query q = em.createQuery("SELECT b from Biome b LEFT join fetch b.especes e ");
		List<Biome> biomes = q.getResultList();

		em.close();
		return biomes;
	}

	
	

	//Acces aux especes APRES le em.close() ✔
	//Possibe de faire des filtres sur les especes ✔
	//Les biomes n'ayant pas d'espece ne sont pas return ✔ 
	//Les biomes ayant plusieurs especes sont return en doublons ✔
	public static List<Biome> showDistinctLeftJoinAfterClose()
	{
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		Query q = em.createQuery("SELECT distinct b from Biome b LEFT join fetch b.especes e ");
		List<Biome> biomes = q.getResultList();

		em.close();
		return biomes;
	}

	
	
	
	//Acces aux activites APRES le em.close() ✔
	//Possibe de faire des filtres sur les activites ✔
	//Les biomes n'ayant pas d'activite ne sont pas return ✔ 
	//Les biomes ayant plusieurs activites sont return en doublons ✔
		public static List<Biome> showDistinctLeftJoinAfterCloseActivites()
		{
			EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

			Query q = em.createQuery("SELECT distinct b from Biome b LEFT join fetch b.activites a ");
			List<Biome> biomes = q.getResultList();

			em.close();
			return biomes;
		}
		
		
		public static List<Biome> BiomeWithActiviteAndEspeceNotWorking()
		{
			EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

			Query q = em.createQuery("SELECT distinct b from Biome b LEFT join fetch b.activites a join fetch b.especes e");
			List<Biome> biomes = q.getResultList();

			em.close();
			return biomes;
		}
		
		
		public static List<Biome> BiomeWithActiviteAndEspece()
		{
			EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

			Query q = em.createQuery("SELECT distinct b from Biome b LEFT join fetch b.activites a");
			List<Biome> biomes = q.getResultList();
			
			q = em.createQuery("SELECT distinct b from Biome b LEFT join fetch b.especes e");
			biomes = q.getResultList();
			
			em.close();
			return biomes;
		}
		
		

	public static void main(String[] args) {



		List<Biome> biomesBdd = BiomeWithActiviteAndEspece();


		for(Biome b : biomesBdd) 
		{
			System.out.println(b);
			System.out.println("Liste des Especes :");

			if(b.getEspeces().isEmpty()) 
			{
				System.out.println("AUCUNE ESPECE DANS CE BIOME");
			}
			for(Espece e : b.getEspeces()) 
			{
				System.out.println(e);
			}
			
			
			
			
			System.out.println("Liste des Activites :");

			if(b.getActivites().isEmpty()) 
			{
				System.out.println("AUCUNE Activite DANS CE BIOME");
			}
			for(Activite a : b.getActivites()) 
			{
				System.out.println(a);
			}
			

			
			System.out.println("-----------");
			
			
			
			
		}







	}




}

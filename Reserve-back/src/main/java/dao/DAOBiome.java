package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import context.Singleton;
import model.Client;
import model.Biome;
import model.Ranger;

public class DAOBiome implements IDAOBiome {


	@Override
	public Biome findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Biome compte = em.find(Biome.class,id);
		em.close();
		return compte;
	}

	@Override
	public List<Biome> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Biome> comptes = em.createQuery("from Biome").getResultList();
		em.close();
		return comptes;
	}

	@Override
	public Biome save(Biome compte) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		compte = em.merge(compte);
		em.getTransaction().commit();
		em.close();
		return compte;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Biome compte = em.find(Biome.class,id);
		em.getTransaction().begin();
		em.remove(compte);
		em.getTransaction().commit();
		em.close();	
	}


	

}

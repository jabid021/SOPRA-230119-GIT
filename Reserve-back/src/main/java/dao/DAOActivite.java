package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import context.Singleton;
import model.Activite;
import model.Client;
import model.Ranger;

public class DAOActivite implements IDAOActivite {


	@Override
	public Activite findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Activite activite = em.find(Activite.class,id);
		em.close();
		return activite;
	}

	@Override
	public List<Activite> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Activite> activites = em.createQuery("from Activite").getResultList();
		em.close();
		return activites;
	}

	@Override
	public Activite save(Activite activite) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		activite = em.merge(activite);
		em.getTransaction().commit();
		em.close();
		return activite;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Activite activite = em.find(Activite.class,id);
		em.getTransaction().begin();
		em.remove(activite);
		em.getTransaction().commit();
		em.close();	
	}


	
	

}

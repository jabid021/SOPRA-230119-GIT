package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Dictateur;
import model.Lutin;

public class DAODictateur implements IDAODictateur {

	@Override
	public Dictateur findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Dictateur dictateur = em.find(Dictateur.class,id);
		em.close();
		return dictateur;
	}

	@Override
	public List<Dictateur> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Dictateur> dictateurs = em.createQuery("from Dictateur").getResultList();
		em.close();
		return dictateurs;
	}

	@Override
	public Dictateur save(Dictateur dictateur) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		dictateur = em.merge(dictateur);
		em.getTransaction().commit();
		em.close();
		return dictateur;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Dictateur dictateur = em.find(Dictateur.class,id);
		em.getTransaction().begin();
		em.remove(dictateur);
		em.getTransaction().commit();
		em.close();	
	}
	

	
}

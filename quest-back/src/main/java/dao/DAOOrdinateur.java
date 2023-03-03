package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Ordinateur;

public class DAOOrdinateur implements IDAOOrdinateur{


	@Override
	public Ordinateur findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Ordinateur ordinateur = em.find(Ordinateur.class,id);
		em.close();
		return ordinateur;
	}

	@Override
	public List<Ordinateur> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Ordinateur> ordinateurs = em.createQuery("from Ordinateur").getResultList();
		em.close();
		return ordinateurs;
	}

	@Override
	public Ordinateur save(Ordinateur ordinateur) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		ordinateur = em.merge(ordinateur);
		em.getTransaction().commit();
		em.close();
		return ordinateur;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Ordinateur ordinateur = em.find(Ordinateur.class,id);
		em.getTransaction().begin();
		em.remove(ordinateur);
		em.getTransaction().commit();
		em.close();	
	}

}

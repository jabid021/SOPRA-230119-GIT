package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Jouet;
import model.Lutin;

public class DAOJouet implements IDAOJouet {

	@Override
	public Jouet findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Jouet jouet = em.find(Jouet.class,id);
		em.close();
		return jouet;
	}

	@Override
	public List<Jouet> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Jouet> jouets = em.createQuery("from Jouet").getResultList();
		em.close();
		return jouets;
	}

	@Override
	public Jouet save(Jouet jouet) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		jouet = em.merge(jouet);
		em.getTransaction().commit();
		em.close();
		return jouet;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Jouet jouet = em.find(Jouet.class,id);
		em.getTransaction().begin();
		em.remove(jouet);
		em.getTransaction().commit();
		em.close();	
	}
	



}

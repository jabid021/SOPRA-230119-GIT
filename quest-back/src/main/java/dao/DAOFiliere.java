package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Filiere;

public class DAOFiliere implements IDAOFiliere{


	@Override
	public Filiere findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Filiere filiere = em.find(Filiere.class,id);
		em.close();
		return filiere;
	}

	@Override
	public List<Filiere> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Filiere> filieres = em.createQuery("from Filiere").getResultList();
		em.close();
		return filieres;
	}

	@Override
	public Filiere save(Filiere filiere) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		filiere = em.merge(filiere);
		em.getTransaction().commit();
		em.close();
		return filiere;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Filiere filiere = em.find(Filiere.class,id);
		em.getTransaction().begin();
		em.remove(filiere);
		em.getTransaction().commit();
		em.close();	
	}

}

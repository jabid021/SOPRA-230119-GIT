package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Enfant;
import model.Lutin;

public class DAOEnfant implements IDAOEnfant {

	@Override
	public Enfant findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Enfant enfant = em.find(Enfant.class,id);
		em.close();
		return enfant;
	}

	@Override
	public List<Enfant> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Enfant> enfants = em.createQuery("from Enfant").getResultList();
		em.close();
		return enfants;
	}

	@Override
	public Enfant save(Enfant enfant) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		enfant = em.merge(enfant);
		em.getTransaction().commit();
		em.close();
		return enfant;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Enfant enfant = em.find(Enfant.class,id);
		em.getTransaction().begin();
		em.remove(enfant);
		em.getTransaction().commit();
		em.close();	
	}
	

	
}

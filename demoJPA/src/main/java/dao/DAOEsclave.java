package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Esclave;
import model.Lutin;

public class DAOEsclave implements IDAOEsclave {

	@Override
	public Esclave findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Esclave esclave = em.find(Esclave.class,id);
		em.close();
		return esclave;
	}

	@Override
	public List<Esclave> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Esclave> esclaves = em.createQuery("from Esclave").getResultList();
		em.close();
		return esclaves;
	}

	@Override
	public Esclave save(Esclave esclave) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		esclave = em.merge(esclave);
		em.getTransaction().commit();
		em.close();
		return esclave;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Esclave esclave = em.find(Esclave.class,id);
		em.getTransaction().begin();
		em.remove(esclave);
		em.getTransaction().commit();
		em.close();	
	}
	

	/*public void delete2(Esclave e) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
	
		em.getTransaction().begin();
		e=em.merge(e);
		em.remove(e);
		em.getTransaction().commit();
		em.close();	
	}*/


}

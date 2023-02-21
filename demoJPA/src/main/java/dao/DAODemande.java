package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Demande;
import model.Lutin;

public class DAODemande implements IDAODemande {

	@Override
	public Demande findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Demande demande = em.find(Demande.class,id);
		em.close();
		return demande;
	}

	@Override
	public List<Demande> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Demande> demandes = em.createQuery("from Demande").getResultList();
		em.close();
		return demandes;
	}

	@Override
	public Demande save(Demande demande) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		demande = em.merge(demande);
		em.getTransaction().commit();
		em.close();
		return demande;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Demande demande = em.find(Demande.class,id);
		em.getTransaction().begin();
		em.remove(demande);
		em.getTransaction().commit();
		em.close();	
	}
	

	
}

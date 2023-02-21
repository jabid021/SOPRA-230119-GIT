package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Visite;
import model.Visite;

public class DAOVisiteJPA implements IDAOVisite {


	@Override
	public Visite findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Visite visite = em.find(Visite.class,id);
		em.close();
		return visite;
	}

	@Override
	public List<Visite> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Visite> visites = em.createQuery("from Visite").getResultList();
		em.close();
		return visites;
	}

	@Override
	public Visite save(Visite visite) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		visite = em.merge(visite);
		em.getTransaction().commit();
		em.close();
		return visite;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Visite visite = em.find(Visite.class,id);
		em.getTransaction().begin();
		em.remove(visite);
		em.getTransaction().commit();
		em.close();	
	}

	@Override
	public List<Visite> findAllByPatient(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();

		List<Visite> visites = em.createQuery("from Visite v where v.patient.id = :id").setParameter("id",id).getResultList();
		em.close();
		return visites;
	}

}

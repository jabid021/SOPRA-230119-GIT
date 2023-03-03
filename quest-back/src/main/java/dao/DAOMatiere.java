package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Matiere;

public class DAOMatiere implements IDAOMatiere{


	@Override
	public Matiere findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Matiere matiere = em.find(Matiere.class,id);
		em.close();
		return matiere;
	}

	@Override
	public List<Matiere> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Matiere> matieres = em.createQuery("from Matiere").getResultList();
		em.close();
		return matieres;
	}

	@Override
	public Matiere save(Matiere matiere) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		matiere = em.merge(matiere);
		em.getTransaction().commit();
		em.close();
		return matiere;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Matiere matiere = em.find(Matiere.class,id);
		em.getTransaction().begin();
		em.remove(matiere);
		em.getTransaction().commit();
		em.close();	
	}

}

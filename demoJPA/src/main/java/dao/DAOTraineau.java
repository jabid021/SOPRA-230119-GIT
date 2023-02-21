package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import context.Singleton;
import model.Traineau;
import model.Lutin;

public class DAOTraineau implements IDAOTraineau {

	@Override
	public Traineau findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Traineau traineau = em.find(Traineau.class,id);
		em.close();
		return traineau;
	}

	@Override
	public List<Traineau> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Traineau> traineaux = em.createQuery("from Traineau").getResultList();
		em.close();
		return traineaux;
	}

	@Override
	public Traineau save(Traineau traineau) {
		
		EntityManager em=null;
		EntityTransaction tx=null;
		
		try {
			
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx=em.getTransaction();
			tx.begin();
			traineau = em.merge(traineau);
			tx.commit();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
			if(tx!=null && tx.isActive()) 
			{
				tx.rollback();
			}
		}
		finally 
		{
			if(em!=null) 
			{
				em.close();
			}
		}
	
		return traineau;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Traineau traineau = em.find(Traineau.class,id);
		em.getTransaction().begin();
		em.remove(traineau);
		em.getTransaction().commit();
		em.close();	
	}
	

	
}

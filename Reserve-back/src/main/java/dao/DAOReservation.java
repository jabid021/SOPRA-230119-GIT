package dao;

import java.util.List;

import javax.persistence.EntityManager;

import context.Singleton;
import model.Reservation;

public class DAOReservation implements IDAOReservation {


	@Override
	public Reservation findById(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Reservation reservation = em.find(Reservation.class,id);
		em.close();
		return reservation;
	}

	@Override
	public List<Reservation> findAll() {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		List<Reservation> reservations = em.createQuery("from Reservation").getResultList();
		em.close();
		return reservations;
	}

	@Override
	public Reservation save(Reservation reservation) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		reservation = em.merge(reservation);
		em.getTransaction().commit();
		em.close();
		return reservation;
	}

	@Override
	public void delete(Integer id) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		Reservation reservation = em.find(Reservation.class,id);
		em.getTransaction().begin();
		em.remove(reservation);
		em.getTransaction().commit();
		em.close();	
	}

	@Override
	public List<Reservation> findAllByClient(Integer idClient) {
		
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Reservation> reservations = em.createQuery("from Reservation f where f.client.id=:id").setParameter("id",idClient).getResultList();
		em.close();
		return reservations;
	}

	@Override
	public List<Reservation> findAllByRanger(Integer idRanger) {
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		List<Reservation> reservations = em.createQuery("from Reservation f where f.ranger.id=:id").setParameter("id",idRanger).getResultList();
		em.close();
		return reservations;
	}

	
	

}

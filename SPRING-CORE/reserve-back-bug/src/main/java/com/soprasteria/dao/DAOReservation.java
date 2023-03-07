package com.soprasteria.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.soprasteria.model.Reservation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class DAOReservation implements IDAOReservation {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Reservation findById(Integer id) {
		return em.find(Reservation.class, id);
	}

	@Override
	public List<Reservation> findAll() {
		return em.createQuery("from Reservation", Reservation.class).getResultList();
	}

	@Override
	@Transactional
	public Reservation save(Reservation reservation) {
		reservation = em.merge(reservation);
		
		return reservation;
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Reservation reservation = em.find(Reservation.class,id);

		em.remove(reservation);
	}

	@Override
	public List<Reservation> findAllByClient(Integer idClient) {
		return em.createQuery("from Reservation f where f.client.id = 0", Reservation.class)
			.getResultList();
	}

	@Override
	public List<Reservation> findAllByRanger(Integer idRanger) {
		return em.createQuery("from Reservation f where f.ranger.id = :id", Reservation.class)
			.setParameter("id", idRanger)
			.getResultList();
	}
}

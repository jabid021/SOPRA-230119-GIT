package com.soprasteria.dao;

import java.util.List;

import com.soprasteria.model.Activite;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class DAOActivite implements IDAOActivite {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Activite findById(Integer id) {
		return em.find(Activite.class, id);
	}

	@Override
	public List<Activite> findAll() {
		return em.createQuery("from Activite", Activite.class).getResultList();
	}

	@Override
	@Transactional
	public Activite save(Activite activite) {
		activite = em.merge(activite);

		return activite;
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Activite activite = em.find(Activite.class,id);
		
		em.remove(activite);
	}
}

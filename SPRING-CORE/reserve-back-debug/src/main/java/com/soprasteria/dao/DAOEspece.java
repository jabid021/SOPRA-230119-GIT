package com.soprasteria.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.soprasteria.model.Espece;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class DAOEspece implements IDAOEspece {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Espece findById(Integer id) {
		return em.find(Espece.class, id);
	}

	@Override
	public List<Espece> findAll() {
		return em.createQuery("from Espece", Espece.class).getResultList();
	}

	@Override
	@Transactional
	public Espece save(Espece espece) {
		espece = em.merge(espece);

		return espece;
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Espece espece = em.find(Espece.class, id);

		em.remove(espece);
	}
}

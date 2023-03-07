package com.soprasteria.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.soprasteria.model.Biome;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class DAOBiome implements IDAOBiome {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Biome findById(Integer id) {
		return em.find(Biome.class, id);
	}

	@Override
	public List<Biome> findAll() {
		return em.createQuery("from Biome", Biome.class).getResultList();
	}

	@Override
	@Transactional
	public Biome save(Biome compte) {
		compte = em.merge(compte);

		return compte;
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Biome compte = em.find(Biome.class, id);

		em.remove(compte);
	}
}

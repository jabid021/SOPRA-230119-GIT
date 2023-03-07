package com.soprasteria.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.soprasteria.model.Client;
import com.soprasteria.model.Compte;
import com.soprasteria.model.Ranger;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class DAOCompte implements IDAOCompte {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Compte findById(Integer id) {
		return em.find(Compte.class, id);
	}

	@Override
	public List<Compte> findAll() {
		return em.createQuery("from Compte", Compte.class).getResultList();
	}

	@Override
	@Transactional
	public Compte save(Compte compte) {
		compte = em.merge(compte);

		return compte;
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		Compte compte = em.find(Compte.class,id);

		em.remove(compte);
	}

	@Override
	public Compte findByLoginAndPassword(String login, String password) {
		Compte connected = null;
		
		try {
			TypedQuery<Compte> q = em.createQuery("from Compte c where c.login = ?1 and c.password = ?2", Compte.class);
			q.setParameter(1, login);
			q.setParameter(2, password);

			connected = q.getSingleResult();
		}

		catch(Exception e) {
			e.printStackTrace();
		}

		return connected;
	}

	@Override
	public List<Ranger> findAllRanger() {
		return em.createQuery("from Ranger", Ranger.class).getResultList();
	}

	@Override
	public List<Client> findAllClient() {
		return em.createQuery("from Client", Client.class).getResultList();
	}
}

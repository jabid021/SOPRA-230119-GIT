package fr.formation.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.formation.model.Produit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class ProduitDao {
	@PersistenceContext // Permet d'injecter (demander à SPRING) un EntityManager (SPRING gère les ouvertures et fermetures)
	private EntityManager em;
	
	public List<Produit> findAll() {
		List<Produit> produits = em
				.createQuery("from Produit", Produit.class)
				.getResultList();
		
		return produits;
	}
	
	@Transactional // (Avec AOP, SPRING va ouvrir la transaction, la commit ou rollback)
	public Produit save(Produit produit) {
//		em.getTransaction().begin(); // donc ça, plus besoin de l'écrire
		
		return em.merge(produit);
		
//		em.getTransaction().commit(); // donc ça, plus besoin de l'écrire
	}
}

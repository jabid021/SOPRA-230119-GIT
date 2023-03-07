package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;

public interface IProduitDao extends JpaRepository<Produit, Integer> {
	// Avec conventions de nommage
	public List<Produit> findAllByPrixBetween(double prixA, double prixB);

	public List<Produit> findAllByFournisseur(Fournisseur fournisseur);
	public List<Produit> findAllByFournisseurId(int fournisseurId);
	
	// Avec @Query
	@Query("select p from Produit p where p.prix between ?1 and ?2")
	public List<Produit> findAllCustomByPrix(double prixA, double prixB);
	
	@Query("select p from Produit p where p.fournisseur.id = ?1")
	public List<Produit> findAllCustomByFournisseur(int fournisseurId);
	
}

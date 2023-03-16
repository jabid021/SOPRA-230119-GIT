package fr.formation.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.model.Fournisseur;

public interface IFournisseurDao extends JpaRepository<Fournisseur, Integer> {
	// SOLUTION #1 Pour charger les produits avec le fournisseur
	@Query("select f from Fournisseur f left join fetch f.produits where f.id = ?1")
	public Optional<Fournisseur> findByIdWithProduits(int id);
}

package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Commentaire;

public interface ICommentaireDao extends JpaRepository<Commentaire, Integer> {
	public List<Commentaire> findAllByProduitId(int produitId);
}

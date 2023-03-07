package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Produit;

public interface IProduitDao extends JpaRepository<Produit, Integer> {

}

package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Fournisseur;

public interface IFournisseurDao extends JpaRepository<Fournisseur, Integer> {

}

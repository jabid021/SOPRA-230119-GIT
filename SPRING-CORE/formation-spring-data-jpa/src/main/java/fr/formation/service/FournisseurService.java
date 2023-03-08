package fr.formation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.dao.IFournisseurDao;
import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;
import jakarta.transaction.Transactional;

@Service
public class FournisseurService {
	@Autowired
	private IFournisseurDao daoFournisseur;
	
	@Transactional
	public void showFournisseur() {
		Optional<Fournisseur> optFournisseur = daoFournisseur.findById(1);
		
		if (optFournisseur.isPresent()) {
			System.out.println(optFournisseur.get().getNom());
			
			for (Produit p : optFournisseur.get().getProduits()) {
				System.out.println(p.getLibelle());
			}
		}
	}
}

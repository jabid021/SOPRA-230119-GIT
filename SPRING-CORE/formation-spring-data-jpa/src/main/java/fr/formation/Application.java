package fr.formation;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.dao.IFournisseurDao;
import fr.formation.dao.IProduitDao;
import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;
import fr.formation.service.FournisseurService;

public class Application {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		IProduitDao daoProduit = context.getBean(IProduitDao.class);
		IFournisseurDao daoFournisseur = context.getBean(IFournisseurDao.class);
		
		
		// Ajout d'un nouveau fournisseur
		Fournisseur fournisseur = new Fournisseur();
		
		fournisseur.setNom("Parachute de France");
		
		daoFournisseur.save(fournisseur);
		
		
		// Ajout de nouveaux produits associés au fournisseur
		Produit produit1 = new Produit();
		
		produit1.setLibelle("Legend R");
		produit1.setPrix(6520);
		produit1.setFournisseur(fournisseur);
		daoProduit.save(produit1);
		
		Produit produit2 = new Produit();
		
		produit2.setLibelle("Legend R2");
		produit2.setPrix(9520);
		produit2.setFournisseur(fournisseur);
		daoProduit.save(produit2);
		
		
		
		
		// Récupérer un produit par son ID
		Optional<Produit> optProduit = daoProduit.findById(1);
		
		if (optProduit.isPresent()) {
			System.out.println(optProduit.get().getLibelle());
		}
		
		
		// Récupérer un fournisseur par son ID
//		Optional<Fournisseur> optFournisseur = daoFournisseur.findById(1);
		// SOLUTION #1 Pour charger les produits avec le fournisseur
		Optional<Fournisseur> optFournisseur = daoFournisseur.findByIdWithProduits(1);
		
		if (optFournisseur.isPresent()) {
			System.out.println(optFournisseur.get().getNom());
			
			for (Produit p : optFournisseur.get().getProduits()) {
				System.out.println(p.getLibelle());
			}
		}
		
		
		
		// SOLUTION #2 Pour charger les produits du fournisseur
		FournisseurService srvFournisseur = context.getBean(FournisseurService.class);
		srvFournisseur.showFournisseur();
		
		
		
		
		// Parcours de la liste
		
//		List<Produit> produits = daoProduit.findAll();
		List<Produit> produits = daoProduit.findAllByPrixBetween(50, 100);
		
		for (Produit p : produits) {
			System.out.println(p.getLibelle());
		}
	}
}

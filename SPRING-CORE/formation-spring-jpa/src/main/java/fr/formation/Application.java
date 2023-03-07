package fr.formation;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.dao.ProduitDao;
import fr.formation.model.Produit;

public class Application {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		
		ProduitDao dao = context.getBean(ProduitDao.class);
		
		
		Produit produit = new Produit();
		
		produit.setLibelle("Démo");
		produit.setPrix(150);
		
//		dao.save(produit);
		
		
		// Parcourir la liste des produits
		List<Produit> produits = dao.findAll();
		
		// Format "classique"
		for (Produit p : produits) {
			System.out.println(p.getLibelle());
		}
		
		// Format lambda fonctionnel (on va lancer la méthode println de System.out pour chaque produit)
		produits.forEach(System.out::println);
		
		// Format lambda (pour chaque produit, on affiche le libellé)
		produits.forEach((p) -> {
			System.out.println(p.getLibelle());
		});
	}
}

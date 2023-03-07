package fr.formation;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.formation.config.AppConfig;
import fr.formation.dao.IProduitDao;
import fr.formation.model.Produit;

public class Application {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		IProduitDao daoProduit = context.getBean(IProduitDao.class);
		
		List<Produit> produits = daoProduit.findAll();
		
		for (Produit p : produits) {
			System.out.println(p.getLibelle());
		}
	}
}

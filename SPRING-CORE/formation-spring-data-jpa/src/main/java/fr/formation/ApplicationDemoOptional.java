package fr.formation;

import java.util.Optional;

import fr.formation.model.Produit;

public class ApplicationDemoOptional {

	public static void main(String[] args) {
//		Produit produit = null;
		Produit simulationProduit = new Produit(100);
		
//		Optional<Produit> optProduit = Optional.empty();
		Optional<Produit> optProduit = Optional.of(simulationProduit);
		
		if (optProduit.isPresent()) {
			System.out.println("ICI " + optProduit.get().getId());			
		}
		
		else {
			System.out.println("Le produit n'existe pas.");
		}
		
		////
		
		Produit produit = optProduit.orElse(new Produit(5));
		System.out.println("ET LA " + produit.getId());
	}

}

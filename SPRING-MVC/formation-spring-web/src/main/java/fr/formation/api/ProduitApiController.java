package fr.formation.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;

//@Controller
@RestController // Combinaison @Controller + @ResponseBody !
public class ProduitApiController {
	@GetMapping("/api/produit/demo")
//	@ResponseBody
	public String demo() {
		return "demo";
	}
	
	@GetMapping("/api/produit/demo-complexe")
	public Produit demoPlusComplexe() {
		Produit produit = new Produit();
		Fournisseur fournisseur = new Fournisseur();
		
		produit.setId(1);
		produit.setLibelle("Démo");
		produit.setFournisseur(fournisseur);
		
		fournisseur.setId(10);
		
		return produit;
	}
}

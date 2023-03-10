package fr.formation.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.dao.IProduitDao;
import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;

//@Controller
@RestController // Combinaison @Controller + @ResponseBody !
@RequestMapping("/api/produit")
public class ProduitApiController {
	@Autowired
	private IProduitDao daoProduit;
	
	@GetMapping
	@JsonView(Views.Produit.class)
	public List<Produit> findAll() {
		return this.daoProduit.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Produit.class)
	public Produit findById(@PathVariable int id) {
		Optional<Produit> optProduit = this.daoProduit.findById(id);
		
		if (optProduit.isPresent()) {
			return optProduit.get();
		}
		
		// TODO déclencher une erreur HTTP ?
		return null;
	}
	
	
	
	@GetMapping("/demo")
//	@ResponseBody
	public String demo() {
		return "demo";
	}
	
	@GetMapping("/demo-complexe")
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

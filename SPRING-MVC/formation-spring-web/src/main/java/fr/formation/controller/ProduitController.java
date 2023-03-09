package fr.formation.controller;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IProduitDao;
import fr.formation.model.Produit;
import fr.formation.request.ProduitRequest;

@Controller
public class ProduitController {
	@Autowired
	private IProduitDao daoProduit;
	
	@GetMapping("/produits")
	public String findAll(Model model) {
		model.addAttribute("produits", this.daoProduit.findAll());
		
		return "liste-produits";
	}

	
	@GetMapping("/produit/ajouter")
	public String add() {
		return "form-produit";
	}

	// Version #1
//	@PostMapping("/produit/ajouter")
//	public String add(@RequestParam String libelle, @RequestParam double prix) {
//		Produit produit = new Produit();
//		
//		produit.setLibelle(libelle);
//		produit.setPrix(prix);
//		
//		this.daoProduit.save(produit);
//		
//		return "redirect:/produits";
//	}
	
	
	// Version #2 - ça fonctionne, mais pas à privilégier
//	@PostMapping("/produit/ajouter")
//	public String add(Produit produit) {
//		this.daoProduit.save(produit);
//		
//		return "redirect:/produits";
//	}
	

	// Version #3 - version la plus commune
	@PostMapping("/produit/ajouter")
	public String add(ProduitRequest produitRequest) {
		Produit produit = new Produit();

//		produit.setLibelle(produitRequest.getLibelle());
//		produit.setPrix(produitRequest.getPrix());
		
		BeanUtils.copyProperties(produitRequest, produit);
		
		this.daoProduit.save(produit);
		
		return "redirect:/produits";
	}
	
	

	@GetMapping("/produit") // /produit?id=10
	public String findByIdRP(@RequestParam int id, Model model) {
		Optional<Produit> optProduit = this.daoProduit.findById(id);
		
		if (optProduit.isPresent()) {
			model.addAttribute("produit", optProduit.get());
		}
		
		return "produit";
	}

	@GetMapping("/produit/{id}") // /produit/10
	public String findByIdPV(@PathVariable int id, Model model) {
		Optional<Produit> optProduit = this.daoProduit.findById(id);
		
		if (optProduit.isPresent()) {
			model.addAttribute("produit", optProduit.get());
		}
		
		return "produit";
	}
	
}

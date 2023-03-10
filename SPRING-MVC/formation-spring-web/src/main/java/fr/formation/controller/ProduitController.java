package fr.formation.controller;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IProduitDao;
import fr.formation.model.Produit;
import fr.formation.request.ProduitRequest;
import jakarta.validation.Valid;

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
	// Pour que la validation s'applique : @Valid
	// Pour récupérer les erreurs de validation, il faut utiliser BindingResult
	// !!! IL FAUT que ce BindingResult soit placé JUSTE APRES @Valid
	// Le @ModelAttribute permettra de réinjecter le produitRequest en attribut "produit" dans le Model
	public String add(@Valid @ModelAttribute("produit") ProduitRequest produitRequest, BindingResult result, Model model) {
		Produit produit = new Produit();

//		produit.setLibelle(produitRequest.getLibelle());
//		produit.setPrix(produitRequest.getPrix());
		
		// S'assurer que les infos saisies sont correctes
		if (result.hasErrors()) {
			// On donne à la JSP toutes les erreurs de validation
			model.addAttribute("error", result);
			
//			model.addAttribute("produit", produitRequest);
			
			// On réaffiche le formulaire
			return "form-produit";
		}
		
//		if (produitRequest.getLibelle() == null || produitRequest.getLibelle().isBlank()) {
//			model.addAttribute("erreur", "Le libellé doit être saisi");
//			
//			return "form-produit";
//		}
		
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
	
	@GetMapping("/produit/modifier/{id}") // /produit/modifier/X
	public String edit(@PathVariable int id, Model model) {
		Optional<Produit> optProduit = this.daoProduit.findById(id);
		
		if (optProduit.isPresent()) {
			// Ca permet d'envoyer le produit à la JSP
			model.addAttribute("produit", optProduit.get());
		}
		
		else {
			// TODO idéalement, afficher une page d'erreur si le produit n'existe pas
			model.addAttribute("erreur", "Le produit n'existe pas!");
		}		
		
		return "form-produit";
	}
	
	@PostMapping("/produit/modifier/{id}") // /produit/modifier/X
	public String edit(@PathVariable int id, ProduitRequest produitRequest) {
		Optional<Produit> optProduit = this.daoProduit.findById(id);
		
		if (optProduit.isPresent()) {
			Produit produit = optProduit.get();
			
			// Ca copie les attributs de produitRequest (libelle, prix) vers les attributs de produit (libelle, prix)
			BeanUtils.copyProperties(produitRequest, produit);
			
			// Ca enregistre les modifications dans la base de données
			this.daoProduit.save(produit);
		}
		
		else {
			// TODO idéalement, afficher une page d'erreur si le produit n'existe pas
			return "error";
		}
		
		return "redirect:/produits";
	}
	
	@GetMapping("/produit/supprimer") // /produit/supprimer?id=X
	public String deleteById(@RequestParam int id) {
		this.daoProduit.deleteById(id);
		
		return "redirect:/produits";
	}
}

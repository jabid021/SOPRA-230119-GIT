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

import fr.formation.dao.IFournisseurDao;
import fr.formation.model.Fournisseur;
import fr.formation.request.FournisseurRequest;
import jakarta.validation.Valid;

@Controller
public class FournisseurController {
	@Autowired
	private IFournisseurDao daoFournisseur;

	// Afficher la liste des fournisseurs
	// Ajouter un fournisseur : afficher le formulaire & traiter les données du formulaire HTML
	// Modifier un fournisseur : afficher le formulaire & traiter les données du formulaire HTML
	// Supprimer un fournisseur
	
	
	@GetMapping("/fournisseurs")
	public String findAll(Model model) {
		model.addAttribute("fournisseurs", this.daoFournisseur.findAll());
		
		return "liste-fournisseurs";
	}
	
	@GetMapping("/fournisseur/ajouter")
	public String add() {
		return "form-fournisseur";
	}
	
	@PostMapping("/fournisseur/ajouter")
	public String add(@Valid @ModelAttribute("fournisseur") FournisseurRequest fournisseurRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("error", result);
			return "form-fournisseur";
		}
		
		Fournisseur fournisseur = new Fournisseur();
		
//		fournisseur.setNom(fournisseurRequest.getNom());
		BeanUtils.copyProperties(fournisseurRequest, fournisseur);
		
		this.daoFournisseur.save(fournisseur);
		
		return "redirect:/fournisseurs";
	}
	
	@GetMapping("/fournisseur/modifier/{id}")
	public String edit(@PathVariable int id, Model model) {
		Optional<Fournisseur> optFournisseur = this.daoFournisseur.findById(id);
		
		if (optFournisseur.isPresent()) {
			model.addAttribute("fournisseur", optFournisseur.get());
		}
		
		return "form-fournisseur";
	}
	
	@PostMapping("/fournisseur/modifier/{id}")
	public String edit(@PathVariable int id, @Valid @ModelAttribute("fournisseur") FournisseurRequest fournisseurRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("error", result);
			return "form-fournisseur";
		}
		
		Optional<Fournisseur> optFournisseur = this.daoFournisseur.findById(id);
		
		if (optFournisseur.isPresent()) {
			Fournisseur fournisseur = optFournisseur.get();
			BeanUtils.copyProperties(fournisseurRequest, fournisseur);
			this.daoFournisseur.save(fournisseur);
		}
		
		return "redirect:/fournisseurs";
	}
	
	@GetMapping("/fournisseur/supprimer/{id}")
	public String deleteById(@PathVariable int id) {
		this.daoFournisseur.deleteById(id);
		
		return "redirect:/fournisseurs";
	}
}

package fr.formation.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IProduitDao;
import fr.formation.model.Produit;

@Controller
@RequestMapping("/produit")
public class ProduitController {
	@Autowired
	private IProduitDao daoProduit;

	@GetMapping // /produit?id=10
	public String findByIdRP(@RequestParam int id, Model model) {
		Optional<Produit> optProduit = this.daoProduit.findById(id);
		
		if (optProduit.isPresent()) {
			model.addAttribute("produit", optProduit.get());
		}
		
		return "/WEB-INF/views/produit.jsp";
	}

	@GetMapping("/{id}") // /produit/10
	public String findByIdPV(@PathVariable int id, Model model) {
		Optional<Produit> optProduit = this.daoProduit.findById(id);
		
		if (optProduit.isPresent()) {
			model.addAttribute("produit", optProduit.get());
		}
		
		return "/WEB-INF/views/produit.jsp";
	}
	
}

package fr.formation.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.dao.IProduitDao;
import fr.formation.exception.ProduitBadRequestException;
import fr.formation.exception.ProduitNotFoundException;
import fr.formation.model.Fournisseur;
import fr.formation.model.Produit;
import fr.formation.request.ProduitByPriceRequest;
import fr.formation.request.ProduitRequest;
import fr.formation.response.ProduitResponse;
import jakarta.validation.Valid;

//@Controller
@RestController // Combinaison @Controller + @ResponseBody !
@RequestMapping("/api/produit")
@CrossOrigin("*") // J'autorise tout le monde
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
//		Optional<Produit> optProduit = this.daoProduit.findById(id);
//		
//		if (optProduit.isPresent()) {
//			return optProduit.get();
//		}
//		
//		throw new ProduitNotFoundException();
		
		// Si le produit existe, on le retourne, sinon, on crée une ProduitNotFoundException, et on la jète
		return this.daoProduit.findById(id).orElseThrow(ProduitNotFoundException::new);
	}
	
//	@GetMapping("/by-price") // /api/produit/by-price?from=10&to=50
	@JsonView(Views.Produit.class)
	public List<Produit> findAllByPriceBetweenRP(@RequestParam double from, @RequestParam double to) {
		return this.daoProduit.findAllByPrixBetween(from, to);
	}
	
	// @RequestBody avec @Get (& @Delete) ne fonctionnent pas, puisqu'on a pas de corps de requêtes pour ces commandes HTTP
	@GetMapping("/by-price") // /api/produit/by-price?from=10&to=50
	@JsonView(Views.Produit.class)
	public List<Produit> findAllByPriceBetween(ProduitByPriceRequest request) {
		return this.daoProduit.findAllByPrixBetween(request.getFrom(), request.getTo());
	}
	
	@PostMapping("/by-price") // /api/produit/by-price
	@JsonView(Views.Produit.class)
	public List<Produit> findAllByPriceBetweenPost(@RequestBody ProduitByPriceRequest request) {
		return this.daoProduit.findAllByPrixBetween(request.getFrom(), request.getTo());
	}
	
	@GetMapping("/by-fournisseur-id/{fournisseurId}") // /api/produit/by-fournisseur-id/1
	@JsonView(Views.Produit.class)
	public List<Produit> findAllByFournisseurId(@PathVariable int fournisseurId) {
		return this.daoProduit.findAllByFournisseurId(fournisseurId);
	}
	
	@GetMapping("/by-fournisseur-id-v2/{fournisseurId}") // /api/produit/by-fournisseur-id/1
	public List<ProduitResponse> findAllByFournisseurIdV2(@PathVariable int fournisseurId) {
		List<Produit> produits = this.daoProduit.findAllByFournisseurId(fournisseurId);
		List<ProduitResponse> responses = new ArrayList<>();
		
		for (Produit produit : produits) {
			ProduitResponse resp = new ProduitResponse();
			
			BeanUtils.copyProperties(produit, resp);
			
			if (produit.getFournisseur() != null) {
				resp.setFournisseurNom(produit.getFournisseur().getNom());				
			}
			
			responses.add(resp);
		}
		
		return responses;
	}
	
	@GetMapping("/by-fournisseur-id-v3/{fournisseurId}") // /api/produit/by-fournisseur-id/1
	public List<ProduitResponse> findAllByFournisseurIdV3(@PathVariable int fournisseurId) {
		return this.daoProduit
					.findAllByFournisseurId(fournisseurId)
					.stream() // On récupère le flux de produits
					.map(produit -> {
						ProduitResponse resp = new ProduitResponse();
						
						BeanUtils.copyProperties(produit, resp);
						
						if (produit.getFournisseur() != null) {
							resp.setFournisseurNom(produit.getFournisseur().getNom());
						}
						
						return resp;
					}) // La fonction "map" permet de transformer
					.toList() // La fonction "toList" permet de transformer le flux en liste
					;
	}
	
	
	@PostMapping
	@JsonView(Views.Produit.class)
	public Produit add(@RequestBody @Valid ProduitRequest produitRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new ProduitBadRequestException();
		}
		
		Produit produit = new Produit();
		
		BeanUtils.copyProperties(produitRequest, produit);
		
		Fournisseur fournisseur = new Fournisseur();
		fournisseur.setId(produitRequest.getFournisseurId());
		
		produit.setFournisseur(fournisseur);
		
		return this.daoProduit.save(produit);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.Produit.class)
	public Produit edit(@PathVariable int id, @RequestBody @Valid ProduitRequest produitRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new ProduitBadRequestException();
		}
		
		Produit produit = this.daoProduit.findById(id).orElseThrow(ProduitNotFoundException::new);
		
		BeanUtils.copyProperties(produitRequest, produit);
		Fournisseur fournisseur = new Fournisseur();
		
		fournisseur.setId(produitRequest.getFournisseurId());
		produit.setFournisseur(fournisseur);
		
		return this.daoProduit.save(produit);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteById(@PathVariable int id) {
		try {
//			this.daoProduit.findById(id).orElseThrow(ProduitNotFoundException::new);
			
			if (!this.daoProduit.existsById(id)) {
				throw new ProduitNotFoundException();
			}
			
			this.daoProduit.deleteById(id);
			
			return true;
		}
		
		catch (Exception e) {
			return false;
		}
	}
	

//	Lister les produits
//	> GET
//	> /api/produit
//
//	Afficher un produit
//	> GET
//	> /api/produit/X
//
//	Ajouter un produit
//	> POST
//	> /api/produit
//
//	Modifier un produit
//	> PUT
//	> /api/produit/X
//
//	Supprimer un produit
//	> DELETE
//	> /api/produit/X
	
	
	
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

package fr.formation.api;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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

import fr.formation.dao.ICommentaireDao;
import fr.formation.dao.IProduitDao;
import fr.formation.exception.CommentaireBadRequestException;
import fr.formation.exception.CommentaireNotFoundException;
import fr.formation.exception.ProduitNotFoundException;
import fr.formation.model.Commentaire;
import fr.formation.model.Produit;
import fr.formation.request.CommentaireRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/commentaire")
public class CommentaireApiController {
	@Autowired
	private ICommentaireDao daoCommentaire;
	
	@Autowired
	private IProduitDao daoProduit;
	
	@GetMapping
	@JsonView(Views.Commentaire.class)
	public List<Commentaire> findAll() {
		return this.daoCommentaire.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.Commentaire.class)
	public Commentaire findById(@PathVariable int id) {
		return this.daoCommentaire.findById(id).orElseThrow(CommentaireNotFoundException::new);
	}
	
	@GetMapping("/by-produit-id") // /api/commentaire/by-produit-id?produitId=1
	@JsonView(Views.Commentaire.class)
	public List<Commentaire> findAllByProduitIdRP(@RequestParam int produitId) {
		return this.daoCommentaire.findAllByProduitId(produitId);
	}
	
	@GetMapping("/by-produit-id/{produitId}") // /api/commentaire/by-produit-id/1
	@JsonView(Views.Commentaire.class)
	public List<Commentaire> findAllByProduitId(@PathVariable int produitId) {
		return this.daoCommentaire.findAllByProduitId(produitId);
	}
	
	@PostMapping
	@JsonView(Views.Commentaire.class)
	public Commentaire add(@Valid @RequestBody CommentaireRequest commentaireRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new CommentaireBadRequestException();
		}
		
		Commentaire commentaire = new Commentaire();
		Produit produit = new Produit();
		
		BeanUtils.copyProperties(commentaireRequest, commentaire);
		
		produit.setId(commentaireRequest.getProduitId());
		
		commentaire.setProduit(produit);
		
		return this.daoCommentaire.save(commentaire);
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.Commentaire.class)
	public Commentaire edit(@PathVariable int id, @Valid @RequestBody CommentaireRequest commentaireRequest, BindingResult result) {
		if (result.hasErrors()) {
			throw new CommentaireBadRequestException();
		}
		
		Commentaire commentaire = this.daoCommentaire.findById(id).orElseThrow(CommentaireNotFoundException::new);
		
		BeanUtils.copyProperties(commentaireRequest, commentaire);
		
		commentaire.setProduit(
			this.daoProduit
				.findById(commentaireRequest.getProduitId())
				.orElseThrow(ProduitNotFoundException::new)
		);
		
		return this.daoCommentaire.save(commentaire);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteById(@PathVariable int id) {
		try {
			this.daoCommentaire.deleteById(id);
			return true;
		}
		
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
